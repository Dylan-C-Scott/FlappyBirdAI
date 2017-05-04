class Hand
{
	Bird b;
	int x; 
	int y;
	int dest_x;
	int dest_y;
	boolean status;
	boolean offScreen;
	Hand(Bird bird)
	{
		status = true; //aka the hand is moving up
		offScreen = false;
		b = bird;
		y = 510;
		x = 510;
	}

	public void update()
	{
		/*if(b.getEnergy() <= 0)
			grab();
			*/
		if(b.energy == 0)
		{
			if(status)
			{
				if(x != b.x)
				{
					if(y - b.y < 5)
						y = b.y;
					x -= 5;
				}
				if(y != b.y)
				{
					if(y - b.y < 5)
						y = b.y;
					y -= 5;
				}
			}

			if(x == b.x && y == b.y)
			{
				status = false;
			}
			if(!status)
			{
				b.moveTheBird(5);
				y += 5;
				b.update();
			}
		}
		if(b.y > 550)
		{
			offScreen = true;
		}
	}

	//idea
	/*public void grab()
	{
		dest_x = b.x;
		dest_y = b.y;
		return;
	}
	*/
	public boolean reachingUp()
	{
		return status;
	}

	public boolean pullingDown()
	{
		return !status;
	}
}