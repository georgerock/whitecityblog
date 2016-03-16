I wrote this site generator because I needed a simple way to update my website, without the fuss of a full-fledged CMS. The generator uses *Markdown* for writing pages and a simple FTP will do to update your content.

The advantage is that you can update your site from anywhere you have an Internet connection and from any device that is *ssh* or *ftp* capable.

You can get the code from [here](https://github.com/adrianrosian/gosite)

### Installation

Get the code and `go get` the dependencies, then compile. Modify `config.json` to fit your needs. 
Run the binary and enjoy!

### Usage

You can run the binary behind a proxy, like *nginx*, or you can use it as it's own server, if you bind it to port 80.

To add menu items, just create folders in the *content* folder. Folders are sorted alphabetically when read, so your menu items will reflect that. The software explodes folder names by `-` and title cases the resulting words. However, if you wish to place a certain folder first, just prefix it with `1-` - any numbers will be stripped from the beginning.

To add content, create markdown files inside the folder. If there is only one markdown file, the page will be displayed as a single page. If there are more files, the page wil display as a blog page. First paragraph is used as blog article summary. The order of display is chronologically reversed.

Enjoy!