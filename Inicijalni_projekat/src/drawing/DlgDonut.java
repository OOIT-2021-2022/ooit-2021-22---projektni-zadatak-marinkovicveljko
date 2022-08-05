package drawing;

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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtYCentre;
	private JTextField txtInnerRadius;
	private JTextField txtRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setTitle("Donut");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenter = new JLabel("Center of donut");
			GridBagConstraints gbc_lblCenter = new GridBagConstraints();
			gbc_lblCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenter.gridx = 1;
			gbc_lblCenter.gridy = 0;
			contentPanel.add(lblCenter, gbc_lblCenter);
		}
		{
			JLabel lblCenterX = new JLabel("X coordinate");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblCenterX.gridx = 2;
			gbc_lblCenterX.gridy = 1;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			txtCenterX = new JTextField();
			GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
			gbc_txtCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterX.anchor = GridBagConstraints.NORTH;
			gbc_txtCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCenterX.gridx = 3;
			gbc_txtCenterX.gridy = 1;
			contentPanel.add(txtCenterX, gbc_txtCenterX);
			txtCenterX.setColumns(10);
		}
		{
			JLabel lblYCenter = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblYCenter = new GridBagConstraints();
			gbc_lblYCenter.anchor = GridBagConstraints.EAST;
			gbc_lblYCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCenter.gridx = 2;
			gbc_lblYCenter.gridy = 2;
			contentPanel.add(lblYCenter, gbc_lblYCenter);
		}
		{
			txtYCentre = new JTextField();
			GridBagConstraints gbc_txtYCentre = new GridBagConstraints();
			gbc_txtYCentre.insets = new Insets(0, 0, 5, 0);
			gbc_txtYCentre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYCentre.gridx = 3;
			gbc_txtYCentre.gridy = 2;
			contentPanel.add(txtYCentre, gbc_txtYCentre);
			txtYCentre.setColumns(10);
		}
		{
			JLabel lblProperties = new JLabel("Properties");
			GridBagConstraints gbc_lblProperties = new GridBagConstraints();
			gbc_lblProperties.insets = new Insets(0, 0, 5, 5);
			gbc_lblProperties.gridx = 1;
			gbc_lblProperties.gridy = 4;
			contentPanel.add(lblProperties, gbc_lblProperties);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner radius");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.gridx = 2;
			gbc_lblInnerRadius.gridy = 5;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			txtInnerRadius = new JTextField();
			GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
			gbc_txtInnerRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnerRadius.gridx = 3;
			gbc_txtInnerRadius.gridy = 5;
			contentPanel.add(txtInnerRadius, gbc_txtInnerRadius);
			txtInnerRadius.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 2;
			gbc_lblRadius.gridy = 6;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 3;
			gbc_txtRadius.gridy = 6;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JButton btnBorderColor = new JButton("Border color");
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnBorderColor.gridx = 1;
			gbc_btnBorderColor.gridy = 7;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JButton btnInnerColor = new JButton("Inner Color");
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 1;
			gbc_btnInnerColor.gridy = 8;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						if(txtInnerRadius.getText().isEmpty() || txtRadius.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "You should fill all of these fields");
						}
						else if(Integer.parseInt(txtInnerRadius.getText())<=0 || Integer.parseInt(txtRadius.getText())<=0)
						{
							JOptionPane.showMessageDialog(null, "Both, inner radius and radius must be greater than 0");
						}
						else if(Integer.parseInt(txtInnerRadius.getText()) > Integer.parseInt(txtRadius.getText()))
						{
							JOptionPane.showMessageDialog(null, "Inner radius shouldn't be greater than radius");
						}
						else
							setVisible(false);
						} catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "You should fill these fields with numbers");
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

}
