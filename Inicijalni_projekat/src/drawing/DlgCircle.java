package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
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

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtRadius;
	private Color borderColor;
	private Color innerColor;
	private JTextField txtCenterY;
	private JButton btnBorderColor;
	private JButton btnInnerColor;
	private boolean okay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setResizable(false);
		setTitle("Circle");
		setModal(true);
		setBounds(100, 100, 365, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 255, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterCoordinate = new JLabel("Center Coordinate");
			GridBagConstraints gbc_lblCenterCoordinate = new GridBagConstraints();
			gbc_lblCenterCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterCoordinate.gridx = 1;
			gbc_lblCenterCoordinate.gridy = 0;
			contentPanel.add(lblCenterCoordinate, gbc_lblCenterCoordinate);
		}
		{
			{
				JLabel lblCenterX = new JLabel("X coordinate");
				GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
				gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
				gbc_lblCenterX.gridx = 2;
				gbc_lblCenterX.gridy = 1;
				contentPanel.add(lblCenterX, gbc_lblCenterX);
			}
			{
				txtCenterX = new JTextField();
				GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
				gbc_txtCenterX.gridwidth = 2;
				gbc_txtCenterX.insets = new Insets(0, 0, 5, 5);
				gbc_txtCenterX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCenterX.gridx = 4;
				gbc_txtCenterX.gridy = 1;
				contentPanel.add(txtCenterX, gbc_txtCenterX);
				txtCenterX.setColumns(10);
			}
			{
				JLabel lblCenterY = new JLabel("Y coordinate");
				GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
				gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
				gbc_lblCenterY.gridx = 2;
				gbc_lblCenterY.gridy = 2;
				contentPanel.add(lblCenterY, gbc_lblCenterY);
			}
			{
				txtCenterY = new JTextField();
				GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
				gbc_txtCenterY.gridwidth = 2;
				gbc_txtCenterY.insets = new Insets(0, 0, 5, 5);
				gbc_txtCenterY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCenterY.gridx = 4;
				gbc_txtCenterY.gridy = 2;
				contentPanel.add(txtCenterY, gbc_txtCenterY);
				txtCenterY.setColumns(10);
			}
			{
				JLabel lblProperties = new JLabel("Properties");
				GridBagConstraints gbc_lblProperties = new GridBagConstraints();
				gbc_lblProperties.anchor = GridBagConstraints.WEST;
				gbc_lblProperties.insets = new Insets(0, 0, 5, 5);
				gbc_lblProperties.gridx = 1;
				gbc_lblProperties.gridy = 3;
				contentPanel.add(lblProperties, gbc_lblProperties);
			}
		}
		{
			{
				JLabel lblRadius = new JLabel("Radius");
				GridBagConstraints gbc_lblRadius = new GridBagConstraints();
				gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblRadius.gridx = 2;
				gbc_lblRadius.gridy = 4;
				contentPanel.add(lblRadius, gbc_lblRadius);
			}
			{
				txtRadius = new JTextField();
				GridBagConstraints gbc_txtRadius = new GridBagConstraints();
				gbc_txtRadius.gridwidth = 2;
				gbc_txtRadius.insets = new Insets(0, 0, 5, 5);
				gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRadius.gridx = 4;
				gbc_txtRadius.gridy = 4;
				contentPanel.add(txtRadius, gbc_txtRadius);
				txtRadius.setColumns(10);
			}
		}
	    btnBorderColor = new JButton("Border Color");
		btnBorderColor.setSize(10, 10);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 borderColor = JColorChooser.showDialog(null, "Please choose border color", btnBorderColor.getBackground());
			 btnBorderColor.setBackground(borderColor);
			}
		});
		btnInnerColor = new JButton("Inner Color");
		btnInnerColor.setSize(10, 10);
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor=JColorChooser.showDialog(null, "Please choose inner color", btnInnerColor.getBackground());
				btnInnerColor.setBackground(innerColor);
			}
		});
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnInnerColor.gridx = 1;
		gbc_btnInnerColor.gridy = 9;
		contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
		gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorderColor.gridx = 2;
		gbc_btnBorderColor.gridy = 9;
		contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(245, 255, 250));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						if(txtRadius.getText().isEmpty())
						{
						JOptionPane.showMessageDialog(null, "Radius field can't be empty!");	
						}
						else if (Integer.parseInt(txtRadius.getText())<=0)
						{
							JOptionPane.showMessageDialog(null, "Radius must be greater than 0");
						}
						else
						{
							okay = true;
							setVisible(false);
						}
						
						} catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Radius must be number");
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
						okay = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtCenterX() {
		return txtCenterX;
	}

	public void setTxtCenterX(JTextField txtCenterX) {
		this.txtCenterX = txtCenterX;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public JTextField getTxtCenterY() {
		return txtCenterY;
	}

	public void setTxtCenterY(JTextField txtCenterY) {
		this.txtCenterY = txtCenterY;
	}

	public boolean isOkay() {
		return okay;
	}

	public void setOkay(boolean okay) {
		this.okay = okay;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}
	
	
	
	
	
	

}
