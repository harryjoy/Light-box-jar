// Copyright (c) 2011, Harsh P. Raval
// All rights reserved.
//
// Redistribution and use in source and binary forms, 
// with or without modification, are permitted provided that the 
// following conditions are met:
//
// Redistributions of source code must retain the above copyright notice, 
// this list of conditions and the following disclaimer.
// 
// Redistributions in binary form must reproduce the above copyright notice, 
// this list of conditions and the following disclaimer in the documentation 
// and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
// THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE 
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS 
// OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY 
// OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
// OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
// THE POSSIBILITY OF SUCH DAMAGE.

package harsh.p.raval.lightbox;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Provides light box like effect using frame and panel.
 * @author harsh
 */
public class LightBox extends JPanel {

	private static final long serialVersionUID = 1312210663916L;
	LightBoxUtil lightBoxUtil;
	
	@Override
	protected void paintComponent(Graphics g1) {
		Graphics2D g = (Graphics2D) g1; 
		g.setPaint(Color.black); 
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); 
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	/**
	 * Create new LightBox instance.
	 */
	public LightBox() {
		this.setOpaque(false);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.addMouseListener(LightBoxMouseListener.getInstance());
		lightBoxUtil = new LightBoxUtil();
	}
	
	/**
	 * Create new LightBox instance.
	 * If modal then all components under light box effect will be not able to generate any 
	 * mouse event until light box panel is closed.
	 * @param modal Whether to make light box effect modal or not.  
	 */
	public LightBox(boolean modal) {
		this.setOpaque(false);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		if(modal)
			this.addMouseListener(LightBoxMouseListener.getInstance());
		lightBoxUtil = new LightBoxUtil();
	}

	/**
	 * To give a light box effect.
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel) {
		frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
		panel.setLocation(((frame.getWidth() - panel.getWidth())/2),(frame.getHeight() - panel.getHeight())/2);
		frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
	}

	/**
	 * To give a light box effect and show pop up panel on desired location.
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 * @param panelLocX X value of location of panel.
	 * @param panelLocY Y value of location of panel.
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel, int panelLocX, int panelLocY) {
		frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
		panel.setLocation(panelLocX, panelLocY);
		frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
	}
	
	/**
	 * To give a light box effect with blinking of window on taskbar and a beep sound.
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 * @param blink Whether to blink frame on taskbar or not.
	 * @param makeSound Whether to make beep sound or not.
	 * @param buzzFrame Whether to give buzz effect to frame or not.
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel, boolean blink, boolean makeSound, boolean buzzFrame) {
		frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
		panel.setLocation(((frame.getWidth() - panel.getWidth())/2),(frame.getHeight() - panel.getHeight())/2);
		frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
		if(blink)
			lightBoxUtil.blinkFrameOnTaskbar(frame);
		if(makeSound)
			lightBoxUtil.makeBeepSound();
		if(buzzFrame)
			lightBoxUtil.buzzFrame(frame);
	}

	/**
	 * To give a light box effect with blinking of window on task bar and a beep sound. Also shows pop up panel on desired location.
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 * @param panelLocX X value of location of panel.
	 * @param panelLocY Y value of location of panel.
	 * @param blink Whether to blink frame on task bar or not.
	 * @param makeSound Whether to make beep sound or not.
	 * @param buzzFrame Whether to give buzz effect to frame or not.
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel, int panelLocX, int panelLocY, boolean blink, boolean makeSound, boolean buzzFrame) {
		frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
		panel.setLocation(panelLocX, panelLocY);
		frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
		if(blink)
			lightBoxUtil.blinkFrameOnTaskbar(frame);
		if(makeSound)
			lightBoxUtil.makeBeepSound();
		if(buzzFrame)
			lightBoxUtil.buzzFrame(frame);
	}

	/**
	 * To give light box effect with specified size of light box shade panel. 
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 * @param panelLocX X value of location of panel.
	 * @param panelLocY Y value of location of panel.
	 * @param size Size of the light box shade panel.
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel, int panelLocX, int panelLocY, Dimension size) throws LightBoxException {
		if(size!=null){
			this.setSize(size);
			this.setLocation((frame.getWidth()-this.getWidth())/2, (frame.getHeight()-this.getHeight())/2);
			frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
			panel.setLocation(panelLocX, panelLocY);
			frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
		} else {
			throw new LightBoxException("Light box shade panel size can't be null.");
		}
	}
	
	/**
	 * To give light box effect with specified size of light box shade panel. 
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 * @param size Size of the light box shade panel.
	 * @throws LightBoxException 
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel, Dimension size) throws LightBoxException {
		if(size!=null){
			this.setSize(size);
			this.setLocation((frame.getWidth()-this.getWidth())/2, (frame.getHeight()-this.getHeight())/2);
			frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
			panel.setLocation(((frame.getWidth() - panel.getWidth())/2),(frame.getHeight() - panel.getHeight())/2);
			frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
		} else {
			throw new LightBoxException("Light box shade panel size can't be null.");
		}
	}
	
	/**
	 * To give light box effect with specified size of light box shade panel. 
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 * @param panelLocX X value of location of panel.
	 * @param panelLocY Y value of location of panel.
	 * @param blink Whether to blink frame on task bar or not.
	 * @param makeSound Whether to make beep sound or not.
	 * @param buzzFrame Whether to give buzz effect to frame or not.
	 * @param size Size of the light box shade panel.
	 * @throws LightBoxException 
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel, int panelLocX, int panelLocY, boolean blink, boolean makeSound, boolean buzzFrame, Dimension size) throws LightBoxException {
		if(size!=null){
			this.setSize(size);
			this.setLocation((frame.getWidth()-this.getWidth())/2, (frame.getHeight()-this.getHeight())/2);
			frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
			panel.setLocation(panelLocX, panelLocY);
			frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
			if(blink)
				lightBoxUtil.blinkFrameOnTaskbar(frame);
			if(makeSound)
				lightBoxUtil.makeBeepSound();
			if(buzzFrame)
				lightBoxUtil.buzzFrame(frame);
		} else {
			throw new LightBoxException("Light box shade panel size can't be null.");
		}
	}
	
	/**
	 * To give light box effect with specified size of light box shade panel. 
	 * @param frame Frame on which light box effect will take place.
	 * @param panel Panel that will be shown as a pop up in light box effect.
	 * @param blink Whether to blink frame on task bar or not.
	 * @param makeSound Whether to make beep sound or not.
	 * @param buzzFrame Whether to give buzz effect to frame or not.
	 * @param size Size of the light box shade panel.
	 * @throws LightBoxException 
	 */
	public void createLightBoxEffect(JFrame frame, JPanel panel, boolean blink, boolean makeSound, boolean buzzFrame, Dimension size) throws LightBoxException {
		if(size!=null){
			this.setSize(size);
			this.setLocation((frame.getWidth()-this.getWidth())/2, (frame.getHeight()-this.getHeight())/2);
			frame.getLayeredPane().add(this,JLayeredPane.PALETTE_LAYER);
			panel.setLocation(((frame.getWidth() - panel.getWidth())/2),(frame.getHeight() - panel.getHeight())/2);
			frame.getLayeredPane().add(panel,JLayeredPane.POPUP_LAYER);
			if(blink)
				lightBoxUtil.blinkFrameOnTaskbar(frame);
			if(makeSound)
				lightBoxUtil.makeBeepSound();
			if(buzzFrame)
				lightBoxUtil.buzzFrame(frame);
		} else {
			throw new LightBoxException("Light box shade panel size can't be null.");
		}
	}
	
	/**
	 * Close light box pop up.
	 * @param jFrame Frame on which light box effect has taken place.
	 * @param jPanel Panel that is shown as a pop up in light box effect.
	 */
	public void closeLightBox(JFrame jFrame, JPanel jPanel) {
		jFrame.getLayeredPane().remove(1);
		jFrame.getLayeredPane().remove(jPanel);
		jFrame.validate();
		jFrame.repaint();
	}
}
//If you find my program useful, you can support my site providing link to 
//my site of this program or to the home page of my site:
//Web site: http://harryjoy.wordpress.com/