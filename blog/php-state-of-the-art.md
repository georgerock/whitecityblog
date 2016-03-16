Here at WhiteCityCode we love Php. It's not necessarily the best language there is, but we are fond of it. While we don't praise it's current state (there are some arguments out there that are pretty strong against it), what Php offers at this point is it's incredible ecosystem.

You can find about anything you need to do in Php. Over the course of the years, we used Php for creating websites or for serial port access (yes, that is possible!). And where Php as a language failed us, the tools available came to the rescue. We are not ashamed, for instance, with the simple approach that [Silex](http://silex.sensiolabs.org) takes to create simple web apps:

-----------------
    require_once __DIR__.'/../vendor/autoload.php'; 
    $app = new Silex\Application(); 
    
    $app->get('/hello/{name}', function($name) use($app) { 
        return 'Hello '.$app->escape($name); 
    }); 
    
    $app->run(); 
-----------------

It is nothing below [Sinatra](http://www.sinatrarb.com/) (from the Ruby world) or [Flask](http://flask.pocoo.org/) (from Python). For larger applications, there is nothing better for rapid application development than [Symfony](http://symfony.com/), [Laravel](http://laravel.com/) or [Zend framework](http://framework.zend.com/). They are robust, well tested and feature a full set of batteries, much like their pythonic counterpart, [Django](https://www.djangoproject.com/). As any large framework, they have a more abrupt learnig curve, but the payoffs in terms of time spent on application development is well worth it.

Php has evolved in terms of standardization as well. The [PSR standards](http://net.tutsplus.com/tutorials/php/psr-huh/) are becoming the norm mainly because of [Composer](http://getcomposer.org/), the shiny new dependency manager for Php that threw Pear off the throne. In combination with [the php QA tools](http://phpqatools.org/) that are available online and with a good build system like [Travis](https://travis-ci.org/) (mainly used by FLOSS projects because it's free for them) or [Jenkins](http://jenkins-ci.org/) - by the way, you can even use git hooks to do a deploy! - Php becomes a real-life language. Done properly, it can even sustain [big projects](http://www.facebook.com).

Php is easy to learn, but it gives you plenty of freedom to create a disaster. So use with caution or [contact a team of professionals](/5-contact)!

