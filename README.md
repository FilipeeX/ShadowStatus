# SHADOV STATUS
A minecraft plugin for changing and checking a status of a minecraft server in a multi-server configuration. 
Made by: filipeex, as an plugin order for Xelo and a free plugin to download from Shadow Code.

## Dependencies
To run this plugin, you need:
1. PlaceholderAPI - you can find the newest version [here](https://www.spigotmc.org/resources/placeholderapi.6245/).

## Preview
Most people use shadov status like for this:
![minecraft holograms with the first line being a name and the second line being a status](https://cdn.discordapp.com/attachments/1172209516373364787/1191507110589104138/image.png?ex=65a5b078&is=65933b78&hm=98540db212da1ba71686e3178dfbe8af14233cd1bd2e672426505f23c7868adf&)

## How to setup
Here you can see the full config.yml, right after generating:
![config.yml](https://lh3.googleusercontent.com/drive-viewer/AEYmBYRVax51K2CHH-rU45TSphc_xfzlUuzYw9X1N2xuXtdGxod61js7Q6oy7LAa59nqO0iz7hASvB263AnMFb5ai3Ht3BYh=s1600)
here are some easy steps for the perfect setup:

### Step 1: Install the plugin onto your minecraft server.
You can download the plugin from [the releases section](https://github.com/FilipeeX/ShadowStatus/releases), and use the latest release.
After that, make sure to run your server at least once, and make sure a folder named 'ShadovStatus' in the plugins/ folder has been automatically created.
After that, you can move on to the step number 2.

### Step 2: Setup your server names.
When you are decided on the names of your servers, you can remove all the servers (server1, 2, 3, 4, 5) under the servers section, and replace them with your own. If you want, you can also add more, or leave less servers than showed in the preview.

### Step 3
Go into the game, log on to your minecraft server and run the command /shadovstatus reload.
If a successfull reload message pops up, you're good to go!
If you know what you're doing, enjoy the plugin.
If you dont, move on to the 'How to use' section.


## How to use
Ptretty much wherever on the server, you can use the placeholder %shadovstatus_<server>%.
This placeholder will return a beutifully formatted status of the chosen server.

The most common usage of this is with holograms. To do this,
choose a hologram plugin, I recommend [DecentHolograms](https://www.spigotmc.org/resources/decentholograms-1-8-1-20-4-papi-support-no-dependencies.96927/),
and use the placeholders in the holograms, which works wonders.

From now on, whenever you need to change a server status, just use the /shadovstatus command, and everything is ready for you.

## Commands
1. /shadovstatus <server|reload> [status] - one and only command of the plugin, this will either reload the configuration, or change the server status.

## Placeholders
1. %shadovstatus_server% - displays a nicely-formatted status of a server, configurable.

## Permissions
1. shadovstatus.admin - Allows the holder to use the /serverstatus command, therefore change the statuses of any server.
