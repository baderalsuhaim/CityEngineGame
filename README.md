# JavaProj
2nd term project for the "Programming in Java" module at City, University of London.

The task is to create a simple 2D Game using the engine provided
by the university based on the JBOX2D engine
for Java. 

The objective of the Game so far is to make the controllable
Walker collect all the coins spawned in the world, which
right now are spawned at hard coded positions, but will
in the future be spawned at random locations on the platforms.

The Game will also implement enemies guarding the coins,
taking away the main Walkers health and stamina upon contact,
and give the Walker the ability to shoot.

There are three levels to the game currently, and each level progresses
upon completion of the current level's objectives. To go
to the next level, the player needs to go through the portal, which
is not active until all the objectives have been met.

The game is controlled using A/D for moving left/right and W for jumping.