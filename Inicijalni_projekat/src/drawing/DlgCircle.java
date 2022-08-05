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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCenter;
	private JTextField txtRadius;

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
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterCoordinate = new JLabel("Center Coordinate");
			GridBagConstraints gbc_lblCenterCoordinate = new GridBagConstraints();
			gbc_lblCenterCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblCenterCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterCoordinate.gridx = 1;
			gbc_lblCenterCoordinate.gridy = 1;
			contentPanel.add(lblCenterCoordinate, gbc_lblCenterCoordinate);
		}
		{
			txtCenter = new JTextField();
			GridBagConstraints gbc_txtCenter = new GridBagConstraints();
			gbc_txtCenter.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenter.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCenter.gridx = 2;
			gbc_txtCenter.gridy = 1;
			contentPanel.add(txtCenter, gbc_txtCenter);
			txtCenter.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 2;
			gbc_txtRadius.gridy = 3;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JButton btnBorderColor = new JButton("Border Color");
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnBorderColor.gridx = 1;
			gbc_btnBorderColor.gridy = 5;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JButton btnInnerColor = new JButton("InnerColor");
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 1;
			gbc_btnInnerColor.gridy = 6;
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
