(ns whitecity.core
  (:require [whitecity.handler :refer [app init destroy]]
            [immutant.web :as immutant]
            [clojure.tools.nrepl.server :as nrepl]
            [taoensso.timbre :as timbre]
            [environ.core :refer [env]]
            [whitecity.settings :refer [read-settings!]]
            [clojure.java.io :as io])
  (:gen-class))

(defonce nrepl-server (atom nil))

(defn parse-port [port]
  (when port
    (cond
      (string? port) (Integer/parseInt port)
      (number? port) port
      :else          (throw (Exception. (str "invalid port value: " port))))))

(defn stop-nrepl []
  (when-let [server @nrepl-server]
    (nrepl/stop-server server)))

(defn start-nrepl
  "Start a network repl for debugging when the :nrepl-port is set in the environment."
  []
  (if @nrepl-server
    (timbre/error "nREPL is already running!")
    (when-let [port (env :nrepl-port)]
      (try
        (->> port
             (parse-port)
             (nrepl/start-server :port)
             (reset! nrepl-server))
        (timbre/info "nREPL server started on port" port)
        (catch Throwable t
          (timbre/error "failed to start nREPL" t))))))

(defn http-port [port]
  (parse-port (or port (env :port) 3000)))

(defonce server (atom nil))

(defn start-http-server [port]
  (init)
  (reset! server (immutant/run app :port port)))

(defn stop-http-server []
  (when @server
    (destroy)
    (immutant/stop @server)
    (reset! server nil)))

(defn stop-app []
  (stop-nrepl)
  (stop-http-server))

(defn start-app [[port settings-file]]
  (if (and 
        (.isFile (io/file settings-file)) 
        (.endsWith (.getName (io/file settings-file))  ".json"))
    (read-settings! settings-file)
    (throw (Exception. (str "invalid settings-file: " settings-file))))
  (.addShutdownHook (Runtime/getRuntime) (Thread. stop-app))
  (start-nrepl)
  (start-http-server (http-port port))
  (timbre/info "server started on port:" (:port @server)))

(defn -main [& args]
  (start-app args))
