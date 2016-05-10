//### 
package nappydevelopment.nappy_the_ingenious.util;

//### IMPORTS ##############################################################################################################################

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Utils {

//### STATIC METHODS #######################################################################################################################
	
	public static BufferedImage getScaledInstance(
		BufferedImage img,
		int targetWidth,
		int targetHeight,
		Object hint,
		double scalFactor,
		boolean higherQuality
	){
		int type = (img.getTransparency() == Transparency.OPAQUE) ?
		BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = (BufferedImage)img;
		
		int w, h;
		
		if (higherQuality) {
			// Use multi-step technique: start with original size, then
			// scale down in multiple passes with drawImage()
			// until the target size is reached
			w = img.getWidth();
			h = img.getHeight();
		} else {
			// Use one-step technique: scale directly from original
			// size to target size with a single drawImage() call
			w = targetWidth;
			h = targetHeight;
		}

		do {
			if (higherQuality && w > targetWidth) {
				w *= scalFactor;
				if (w < targetWidth) {
					w = targetWidth;
				}
			}
			if (higherQuality && h > targetHeight) {
				h *= scalFactor;
				if (h < targetHeight) {
					h = targetHeight;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();
			
			ret = tmp;
		} while (w != targetWidth || h != targetHeight);

		return ret;
		}

	public static Image getScaledInstance(
		Image img,
		int targetWidth,
		int targetHeight,
		Object hint,
		double scalFactor,
		boolean higherQuality
	){
		Image helpImg = null;
		
		BufferedImage buffImg = SwingFXUtils.fromFXImage(img, null);
		BufferedImage scalImg = Utils.getScaledInstance(
			buffImg,
			targetWidth,
			targetHeight,
			hint,
			scalFactor,
			higherQuality
		);
    	
    	return SwingFXUtils.toFXImage(scalImg, (WritableImage)helpImg);
	}

}
//### EOF ##################################################################################################################################