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

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Light box utility class that provides utility method used by LightBox class.
 * @author harsh
 */
public final class LightBoxUtil {
	
	/**
	 * 
	 */
	protected LightBoxUtil() {
	}
	
	/**
	 * Give buzz effect to frame.
	 * @author harsh
	 */
	protected void buzzFrame(JFrame frame) {
		try { 
			final int frameX = frame.getLocationOnScreen().x, 
					frameY = frame.getLocationOnScreen().y; 
			for(int i = 0; i < 20; i++) { 
				Thread.sleep(10); 
				frame.setLocation(frameX, frameY + 5); 
				Thread.sleep(10); 
				frame.setLocation(frameX, frameY - 5);
				Thread.sleep(10); 
				frame.setLocation(frameX + 5, frameY);
				Thread.sleep(10); 
				frame.setLocation(frameX, frameY); 
			}
		} 
		catch (Exception e) { 
			e.printStackTrace();
		}
	}

	/**
	 * Blinks frame's task bar entry for attention.
	 * @param frame Frame object.
	 * @author harsh
	 */
	protected void blinkFrameOnTaskbar(JFrame frame){
		if(!frame.hasFocus() || frame.getExtendedState() == JFrame.ICONIFIED){
			frame.setVisible(true);
		}
	}
	
	/**
	 * Makes a beep sound.
	 */
	protected void makeBeepSound() {
		Toolkit.getDefaultToolkit().beep();
	}
}
//If you find my program useful, you can support my site providing link to 
//my site of this program or to the home page of my site:
//Web site: http://harryjoy.wordpress.com/