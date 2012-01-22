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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * If light box is modal then this listener will be added to light box 
 * so that all mouse clicks and other mouse events comes in this class and 
 * not get passed to underlying components. 
 * This is the simplest way I thought about making light box effect modal.
 * @author harsh
 */
public class LightBoxMouseListener implements MouseListener {
	
	private static LightBoxMouseListener lightBoxMouseListener = new LightBoxMouseListener(); 
	
	private LightBoxMouseListener(){
	}
	
	public static LightBoxMouseListener getInstance(){
		if(lightBoxMouseListener == null)
			lightBoxMouseListener = new LightBoxMouseListener();
		return lightBoxMouseListener;
	}
	
	//--- Do nothing on mouse events to make our light box panel modal.
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
//If you find my program useful, you can support my site providing link to 
//my site of this program or to the home page of my site:
//Web site: http://harryjoy.wordpress.com/