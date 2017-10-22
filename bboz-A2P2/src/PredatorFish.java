import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.io.File;

import javax.imageio.ImageIO;

public class PredatorFish extends Creature{
	
	private int detectionRadius;

	private boolean fishHunger;
	private Image fishHeadHappyImage;
	private Image fishHeadSadImage;
	
	public PredatorFish() {
		super();
		setShapeAttributes();
		fishHunger = false;
		anchorPoint.x = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getWidth())-150));
		anchorPoint.y = Math.abs(((int)(Math.random()*EnviromentPanel.getPanel().getHeight())-150));
		creatureColor = new Color(181,29,126);
		scaleFactor = 1f;
		eyeColor = creatureColor;
		
	}
	
	@Override
	protected void setShapeAttributes() {
		super.setShapeAttributes();
		try {
			fishHeadHappyImage = ImageIO.read(new File("Images/happy.png"));
			fishHeadSadImage = ImageIO.read(new File("Images/sad.png"));
		}catch (Exception e) {
			System.out.print("fishHeadNotFound");	
		}
		
		
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		AffineTransform af = new AffineTransform();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		

		g.translate((int)anchorPoint.x, (int)anchorPoint.y);
		g.scale(scaleFactor, scaleFactor);
		if(speedVector.x < 0)
			g.scale(1, -1);
		float angle = speedVector.heading();									//Point Fish to position vector
		g.rotate(angle);			

		
		
		if(fishHunger)
			g.drawImage(fishHeadSadImage, 110- fishWidth + 60, 25 - fishHeight, 70, 70, null);
		else
			g.drawImage(fishHeadHappyImage, 110- fishWidth + 60, 25 - fishHeight, 70, 70, null);
		
		g.setTransform(af);
		
		
	}
	
	
	
	
}
