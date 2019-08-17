package com.fhtiger.plugins.magic.toolwindow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.*;

public class WindowTextDialog extends JDialog {
	private JPanel contentPane;
	private JButton buttonOK;
	private JButton buttonCancel;
	private JPanel textAreaPanel;
	private JTextArea textArea;
	private String content;

	public WindowTextDialog(ToolWindow toolWindow) {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);

		buttonOK.addActionListener(e -> onOK());

		buttonCancel.addActionListener(e -> onCancel());

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});

		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}

	private void onOK() {
		// add your code here
		this.content = this.textArea.getText();
		dispose();
	}

	private void onCancel() {
		// add your code here if necessary
		dispose();
	}

	public String getContent() {
		return content;
	}

	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	/*
	public static void main(String[] args) {
		WindowTextDialog dialog = new WindowTextDialog();
		dialog.pack();
		dialog.setVisible(true);
		System.exit(0);
	}*/
}
