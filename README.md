#ANSSRPG
## What it is:
ANSSRPG is a mod for Minecraft Forge that provides players, modpackers and server admins the ability to develop their own unique RPG system  with player progression without any programming knowledge needed.
## How it works:
ANSSRPG boils down to two fundimential concepts
###Skills:
Primarily used to award a player with experience for doing things. For example you can create a 'Mining' skill that provides players with experience for mining ores. For example Iron Ore for 5 experience and Diamond Ore for 50 experience. Skills follow a few preset types but can be combined to create compound skills. All skills have a failure state which allows progression to be handled via the mod (a 'digging' skill will not allow a player to mine a block)

###Perks:
Perks come in two flavours: Unlocks and Effects

Unlock Perks allow failure states to be represented. If a perk if presant and the player does not have it they will trigger the failure state, if they do have it however the failure state will _not_ be triggered. If there are no unlock perks defined for 'x' then there will not be a failure state for it.

Effect Perks allow for effects (potion effects at this time) to be applied to players [among other things](https://github.com/disconsented/ANSSRPG/wiki/Action-perks-design-doc)

#How to report a issue or get help
1. Read the wiki and other resources for the mod
2. Read: http://www.chiark.greenend.org.uk/~sgtatham/bugs.html
3. Using a service like pastbin (no dropbox) upload:
 1. Any crash reports
 2. Console logs (bother server.log and fml logs)
 3. All Config files 
4. Create a github issue with the following information:
 * Description of the issue:
 * Steps to reproduce it:
 * Steps taken to resolve it:
 * Logs uploaded

N.B. If you're looking for help via IRC read [this](http://programmers.stackexchange.com/a/154678)

#Builds
Master: [![Build Status](https://travis-ci.org/disconsented/ANSSRPG.svg?branch=master)](https://travis-ci.org/disconsented/ANSSRPG)

Dev: [![Build Status](https://travis-ci.org/disconsented/ANSSRPG.svg?branch=DEV)](https://travis-ci.org/disconsented/ANSSRPG)