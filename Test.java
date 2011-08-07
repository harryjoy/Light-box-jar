import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import harsh.p.raval.lightbox.LightBox;
import harsh.p.raval.lightbox.LightBoxException;

public class Test {

	static JButton button = new JButton("lightBox.createLightBoxEffect(frame, panel);");
	static JButton button1 = new JButton("lightBox.createLightBoxEffect(frame, panel, 100, 100);");
	static JButton button2 = new JButton("lightBox.createLightBoxEffect(frame, panel, new Dimension(200, 200));");
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new FlowLayout());
		
		final JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.blue));
		panel.setSize(100,100);
		panel.setBackground(Color.black);
		panel.setLayout(new BorderLayout());
		
		JButton jButton = new JButton("Close");
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LightBox lightBox = new LightBox();
				lightBox.closeLightBox(frame, panel);
				frame.setResizable(true);
				if(!button.isEnabled())
					button.setEnabled(true);
				if(!button1.isEnabled())
					button1.setEnabled(true);
				if(!button2.isEnabled())
					button2.setEnabled(true);
			}
		});
		panel.add(jButton,BorderLayout.NORTH);
		panel.add(new JLabel("Light box panel"),BorderLayout.CENTER);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LightBox lightBox = new LightBox();
				lightBox.createLightBoxEffect(frame, panel);
				frame.setResizable(false);
			}
		});
		frame.add(button);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LightBox lightBox = new LightBox();
				lightBox.createLightBoxEffect(frame, panel, 100, 100);
				frame.setResizable(false);
			}
		});
		frame.add(button1);
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LightBox lightBox = new LightBox();
				try {
					lightBox.createLightBoxEffect(frame, panel, new Dimension(200, 200));
				} catch (LightBoxException e) {
					e.printStackTrace();
				}
				frame.setResizable(false);
				button.setEnabled(false);
				button1.setEnabled(false);
				button2.setEnabled(false);
			}
		});
		frame.add(button2);

		frame.setVisible(true);
	}
}