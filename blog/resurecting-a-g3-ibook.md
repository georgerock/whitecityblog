This week I saw for the first time and **Apple G3 IBook** that I assume is the 2004 model. It's an interesting piece of machinery that I guess looked amazing at that state of technology.

The characteristics are rather poor for today's requirements: it features a 500Mhz processor (32bit) and 750Mb of RAM (SDRAM that is). 

I was resurrecting the laptop for a friend's daughter, because the **Mac OS** that was installed was no longer supported and *Safari* was outdated, resulting in not even the most commonly used sites here (read Facebook) being able to load.

Since I knew nothing about the system I started digging a bit and found out, to my big surprise and even bigger satisfaction that the main Linux distributions support the architecture (powerpc) and that it should be fairly easy to install.

The biggest problem was that at the time when I started the installation I had no CDs with low-burning rate to match the system's CD-ROM, so I had to look for a solution to install the OS from a USB stick. It turns out that creating a bootable USB stick in this case was easy enough:

1. identify the disk drive (I looked in GParted), in my case `/dev/sdc`
2. use `dd` to copy the correct downloaded image for the architecture (I used **Debian**, as neither Lubuntu or Xubuntu seemed to want to work - careful to download the `powerpc` distro): 

--------------
    sudo dd if=~/Download/debian-7.3.0-powerpc-lxde-CD-1.iso of=/dev/sdc bs=32768 conv=notrunc,noerror,sync
--------------
    
To start the Debian installation, boot into **OpenFirmware** by inserting the USB stick into the left side while the system is off, hitting the power button and immediately start holding the `Cmd+Option+O+F` combo down until you get a blank screen with a prompt.

At the prompt type `boot usb0/disk@1:,\\yaboot` and hit `Enter`. You should see `yaboot` starting to load the kernel `Elf`, then you should get a prompt asking for the command to run. We use `install32` here, as the G3 is a 32bit system. Sure enough, the Debian installer starts to run. If you want Debian to auto-configure the network, make sure that you also have the network cable plugged in.

That's it. I am waiting now for Debian to download the packages form the Romanian mirror. Should everything go ok, I shouldn't have to fiddle with video configuration or anything else (I understand the 128Mb *ATI Rage video* might be a problem). Fingers crossed!
