package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgSort extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCircleX;
	private JTextField txtCircleY;
	private JTextField txtRadius;
	private int var = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgSort dialog = new DlgSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgSort() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCircleX = new JLabel("X coordinate");
			GridBagConstraints gbc_lblCircleX = new GridBagConstraints();
			gbc_lblCircleX.anchor = GridBagConstraints.EAST;
			gbc_lblCircleX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCircleX.gridx = 2;
			gbc_lblCircleX.gridy = 0;
			contentPanel.add(lblCircleX, gbc_lblCircleX);
		}
		{
			txtCircleX = new JTextField();
			GridBagConstraints gbc_txtCircleX = new GridBagConstraints();
			gbc_txtCircleX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCircleX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCircleX.gridx = 3;
			gbc_txtCircleX.gridy = 0;
			contentPanel.add(txtCircleX, gbc_txtCircleX);
			txtCircleX.setColumns(10);
		}
		{
			JLabel lblCircleY = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblCircleY = new GridBagConstraints();
			gbc_lblCircleY.anchor = GridBagConstraints.EAST;
			gbc_lblCircleY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCircleY.gridx = 2;
			gbc_lblCircleY.gridy = 3;
			contentPanel.add(lblCircleY, gbc_lblCircleY);
		}
		{
			txtCircleY = new JTextField();
			GridBagConstraints gbc_txtCircleY = new GridBagConstraints();
			gbc_txtCircleY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCircleY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCircleY.gridx = 3;
			gbc_txtCircleY.gridy = 3;
			contentPanel.add(txtCircleY, gbc_txtCircleY);
			txtCircleY.setColumns(10);
		}
		{
			JLabel lblCircleRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblCircleRadius = new GridBagConstraints();
			gbc_lblCircleRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblCircleRadius.gridx = 2;
			gbc_lblCircleRadius.gridy = 6;
			contentPanel.add(lblCircleRadius, gbc_lblCircleRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 3;
			gbc_txtRadius.gridy = 6;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
							if(txtCircleX.getText().isEmpty() || txtCircleY.getText().isEmpty() || txtRadius.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "You need to fill all of the fields");
							}
							if (Integer.parseInt(txtRadius.getText())<=0)
							{
								JOptionPane.showMessageDialog(null, "Radius must be greater than 0");
							}
							else
							{
								setVisible(false);
								var=1;
							}
							
						} catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "You must enter numbers!");
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtCircleX() {
		return txtCircleX;
	}

	public void setTxtCircleX(JTextField txtCircleX) {
		this.txtCircleX = txtCircleX;
	}

	public JTextField getTxtCircleY() {
		return txtCircleY;
	}

	public void setTxtCircleY(JTextField txtCircleY) {
		this.txtCircleY = txtCircleY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public int getVar() {
		return var;
	}

	public void setVar(int var) {
		this.var = var;
	}
	
	
	

}
