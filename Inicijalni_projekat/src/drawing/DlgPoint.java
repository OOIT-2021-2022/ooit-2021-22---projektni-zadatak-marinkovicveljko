package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JButton btnBorderColor;
	private Point p;
	private Color color;
	private boolean okay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setResizable(false);
		setTitle("Point");
		setModal(true);
		setBounds(100, 100, 260, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCoordinate = new JLabel("X coordinate");
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
			gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinate.gridx = 1;
			gbc_lblXCoordinate.gridy = 0;
			contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
		}
		{
			txtXCoordinate = new JTextField();
			GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
			gbc_txtXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXCoordinate.gridx = 2;
			gbc_txtXCoordinate.gridy = 0;
			contentPanel.add(txtXCoordinate, gbc_txtXCoordinate);
			txtXCoordinate.setColumns(10);
		}
		{
			JLabel lblYCoordinate = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.gridx = 1;
			gbc_lblYCoordinate.gridy = 3;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			{
				txtYCoordinate = new JTextField();
				GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
				gbc_txtYCoordinate.insets = new Insets(0, 0, 5, 5);
				gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYCoordinate.gridx = 2;
				gbc_txtYCoordinate.gridy = 3;
				contentPanel.add(txtYCoordinate, gbc_txtYCoordinate);
				txtYCoordinate.setColumns(10);
			}
		}
		btnBorderColor = new JButton("Border Color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    color=JColorChooser.showDialog(null, "Please choose color", btnBorderColor.getBackground());
		    btnBorderColor.setBackground(color);
			}
		});
		GridBagConstraints gbc_btnBorderColor_1 = new GridBagConstraints();
		gbc_btnBorderColor_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorderColor_1.gridx = 1;
		gbc_btnBorderColor_1.gridy = 8;
		contentPanel.add(btnBorderColor, gbc_btnBorderColor_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(250, 235, 215));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okay=true;
						setVisible(false);
						
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
						okay = false;
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
	
	

	public boolean isOkay() {
		return okay;
	}

	public void setOkay(boolean okay) {
		this.okay = okay;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
	}

	public JTextField getTxtYCoordinate() {
		return txtYCoordinate;
	}

	public void setTxtYCoordinate(JTextField txtYCoordinate) {
		this.txtYCoordinate = txtYCoordinate;
	}
	public JButton getBtnBorderColor()
	{
		return btnBorderColor;
	}
	public void setBtnBorderColor(JButton btnBorderColor)
	{
		this.btnBorderColor = btnBorderColor;
	}
	
	
	

}
