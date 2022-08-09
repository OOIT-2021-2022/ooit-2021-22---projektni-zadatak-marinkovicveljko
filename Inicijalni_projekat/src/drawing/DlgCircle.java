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
		setTitle("Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterCoordinate = new JLabel("Center Coordinate");
			GridBagConstraints gbc_lblCenterCoordinate = new GridBagConstraints();
			gbc_lblCenterCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblCenterCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterCoordinate.gridx = 1;
			gbc_lblCenterCoordinate.gridy = 0;
			contentPanel.add(lblCenterCoordinate, gbc_lblCenterCoordinate);
		}
		{
			JButton btnBorderColor = new JButton("Border Color");
			btnBorderColor.setSize(10, 10);
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				 borderColor = JColorChooser.showDialog(null, "Please choose border color", borderColor);
				 btnBorderColor.setBackground(borderColor);
				}
			});
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
				gbc_txtCenterX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCenterX.gridx = 3;
				gbc_txtCenterX.gridy = 1;
				contentPanel.add(txtCenterX, gbc_txtCenterX);
				txtCenterX.setColumns(10);
			}
			{
				JLabel lblCenterY = new JLabel("Y coordinate");
				GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
				gbc_lblCenterY.anchor = GridBagConstraints.EAST;
				gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
				gbc_lblCenterY.gridx = 2;
				gbc_lblCenterY.gridy = 2;
				contentPanel.add(lblCenterY, gbc_lblCenterY);
			}
			{
				txtCenterY = new JTextField();
				GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
				gbc_txtCenterY.insets = new Insets(0, 0, 5, 0);
				gbc_txtCenterY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCenterY.gridx = 3;
				gbc_txtCenterY.gridy = 2;
				contentPanel.add(txtCenterY, gbc_txtCenterY);
				txtCenterY.setColumns(10);
			}
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
				gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
				gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRadius.gridx = 3;
				gbc_txtRadius.gridy = 4;
				contentPanel.add(txtRadius, gbc_txtRadius);
				txtRadius.setColumns(10);
			}
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnBorderColor.gridx = 1;
			gbc_btnBorderColor.gridy = 6;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JButton btnInnerColor = new JButton("InnerColor");
			btnInnerColor.setSize(10, 10);
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColor=JColorChooser.showDialog(null, "Please choose inner color", innerColor);
					btnInnerColor.setBackground(innerColor);
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 1;
			gbc_btnInnerColor.gridy = 7;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
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
	
	
	
	

}
