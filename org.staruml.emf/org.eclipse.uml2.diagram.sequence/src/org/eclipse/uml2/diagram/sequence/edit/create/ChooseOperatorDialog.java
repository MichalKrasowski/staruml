package org.eclipse.uml2.diagram.sequence.edit.create;

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.InteractionOperatorKind;

public class ChooseOperatorDialog extends Dialog {
    private OperatorProperties myResult;
    private ChooseOperatorPanel myChooseOperatorPanel;
    private final InteractionOperatorKind[] myOperatorInfos;

    public ChooseOperatorDialog(Shell parentShell) {
        super(parentShell);
        setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL );
        myOperatorInfos = (InteractionOperatorKind[]) InteractionOperatorKind.VALUES.toArray(new InteractionOperatorKind[InteractionOperatorKind.VALUES.size()]);
        Arrays.sort(myOperatorInfos);
    }
    
    OperatorProperties getResult() {
        return myResult;
    }
    
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText("New Combined Fragment");
    }
    
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        createChooseOperatorPanel(composite);
        return composite;
    }
    
    protected void okPressed() {
        myResult = myChooseOperatorPanel.getPropertyEditor().getResult();// create result before controls are disposed
        super.okPressed();
    }
    
    private void createChooseOperatorPanel(Composite composite) {
        myChooseOperatorPanel = new ChooseOperatorPanel(composite);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 400;//XXX
        gd.heightHint = 300;
//        Point size = myChooseOperatorPanel.getRootControl().computeSize(SWT.DEFAULT, SWT.DEFAULT);
//        gd.widthHint = size.x;
//        gd.heightHint = size.y;
        myChooseOperatorPanel.getRootControl().setLayoutData(gd);
    }

    private IStructuredContentProvider getContentProvider() {
        return new IStructuredContentProvider() {
            public Object[] getElements(Object inputElement) {
                return myOperatorInfos;
            }
            public void dispose() {
            }
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
        };
    }
    
    static class OperatorProperties  {
        OperatorProperties(final InteractionOperatorKind operatorKind, final String arguments, final int numberOfOperands) {
            super();
            myOperatorKind = operatorKind;
            myArguments = arguments;
            myNumberOfOperands = numberOfOperands;
        }
        String getArguments() {
            return myArguments;
        }
        int getNumberOfOperands() {
            return myNumberOfOperands;
        }
        InteractionOperatorKind getOperatorKind() {
            return myOperatorKind;
        }
        private final InteractionOperatorKind myOperatorKind;
        private final String myArguments;
        private final int myNumberOfOperands;
    }
    
    class ChooseOperatorPanel {
        public ChooseOperatorPanel(Composite parent) {
            myPanel = new Group(parent, SWT.NORMAL);
            myPanel.setText("Combined Fragment Options");
            myPanel.setLayout(new GridLayout(2,false));
            createOperatorsList();
            createOperatorPropertyEditor();
            //initial selection
            myList.setSelection(0);
            myPropertyEditor.setCurrentOperatorInfo(myOperatorInfos[0]);
        }
        
        Control getRootControl() {
            return myPanel;
        }
        
        OperatorPropertyEditor getPropertyEditor() {
            return myPropertyEditor;
        }
        
        private void createOperatorsList() {
            myList = new List(myPanel, SWT.V_SCROLL | SWT.BORDER);
            GridData gd = new GridData(GridData.FILL_VERTICAL);
            gd.widthHint = 90;//TODO: calculate it dynamically
            myList.setLayoutData(gd);
            myList.addMouseListener(new MouseAdapter() {
                public void mouseDown(MouseEvent e) {
                    updateSelectedOperator();
                }
            });
            myList.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    updateSelectedOperator();
                }
            });
            
            myListViewer = new ListViewer(myList);
            myListViewer.setContentProvider(getContentProvider());
            myListViewer.setLabelProvider(new OperatorNameLabelProvider());
            myListViewer.setInput(Collections.EMPTY_SET);
        }
        
        private void createOperatorPropertyEditor() {
            myPropertyEditor = new OperatorPropertyEditor(myPanel);
            GridData gd = new GridData(GridData.FILL_BOTH);
            gd.grabExcessHorizontalSpace = true;
            myPropertyEditor.setLayoutData(gd);
        }
        
        private void updateSelectedOperator() {
            int index = myList.getSelectionIndex();
            InteractionOperatorKind info = myOperatorInfos[index];
            myPropertyEditor.setCurrentOperatorInfo(info);
        }

        private final Group myPanel;
        private ListViewer myListViewer;
        private OperatorPropertyEditor myPropertyEditor;
        private List myList;
        
        class OperatorNameLabelProvider extends LabelProvider implements IBaseLabelProvider {
            public String getText(Object element) {
            	InteractionOperatorKind info = (InteractionOperatorKind)element;
                return info.getName();
            }
        }
        
        class OperatorPropertyEditor extends Composite {
            private final Label myArgumentsLabel;
            private final Text myArgumentsText;
            private final Label myNumberOfOperandsLabel;
            private final Text myNumberOfOperandsText;
            private final Button myCancelUMLCheckBox;
            private final Label myCancelUMLLabel;
            private final Composite myCancelUMLPanel;
            private final Label myOperatorNameLabel;
            private final Text myOperatorNameText;
            private InteractionOperatorKind myCurrentInfo;

            public OperatorPropertyEditor(Composite parent) {
                super(parent, SWT.NORMAL);
                setLayout(new GridLayout());
                
                myOperatorNameLabel = new Label(this, SWT.NORMAL);
                GridData gd = new GridData(SWT.BEGINNING);
                myOperatorNameLabel.setLayoutData(gd);
                myOperatorNameLabel.setText("Operator name:");
                
                myOperatorNameText = new Text(this, SWT.BORDER);
                gd = new GridData(GridData.FILL_HORIZONTAL);
                myOperatorNameText.setLayoutData(gd);

                myArgumentsLabel = new Label(this, SWT.NORMAL);
                gd = new GridData(SWT.BEGINNING);
                myArgumentsLabel.setLayoutData(gd);
                myArgumentsLabel.setText("Arguments:");
                
                myArgumentsText = new Text(this, SWT.BORDER);
                gd = new GridData(GridData.FILL_HORIZONTAL);
                myArgumentsText.setLayoutData(gd);
                
                myNumberOfOperandsLabel = new Label(this, SWT.NORMAL);
                gd = new GridData(SWT.BEGINNING);
                myNumberOfOperandsLabel.setLayoutData(gd);
                myNumberOfOperandsLabel.setText("Number of operands:");
                
                myNumberOfOperandsText = new Text(this, SWT.BORDER);
                gd = new GridData(GridData.FILL_HORIZONTAL);
                myNumberOfOperandsText.setLayoutData(gd);
                myNumberOfOperandsText.addListener (SWT.Verify, new Listener () {
                    public void handleEvent (Event e) {
                        if (myNumberOfOperandsText.getText().length() >= 2 && e.text.length() > 0) {// at most 2 digits allowed
                            e.doit = false;
                            return;
                        }
                        String text = e.text;//Only digits allowed
                        char [] chars = new char [text.length ()];
                        text.getChars (0, chars.length, chars, 0);
                        for (int i=0; i<chars.length; i++) {
                            if (!('0' <= chars [i] && chars [i] <= '9')) {
                                e.doit = false;
                                return;
                            }
                        }
                    }
                });                
                
                
                myCancelUMLPanel = new Composite(this, SWT.NORMAL);
                gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
                myCancelUMLPanel.setLayoutData(gd);
                myCancelUMLPanel.setLayout(new GridLayout(2, false));
                
                myCancelUMLCheckBox = new Button(myCancelUMLPanel, SWT.CHECK);
                gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
                myCancelUMLCheckBox.setLayoutData(gd);
                myCancelUMLCheckBox.addSelectionListener(new SelectionAdapter() {
                   public void widgetSelected(SelectionEvent e) {
                       setUMLConstraints(myCancelUMLCheckBox.getSelection());
                   } 
                });
                
                myCancelUMLLabel = new Label(myCancelUMLPanel, SWT.NORMAL);
                gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
                myCancelUMLLabel.setLayoutData(gd);
                myCancelUMLLabel.setText("Cancel UML limitations");
            }
            
            void setCurrentOperatorInfo(InteractionOperatorKind info) {
                myCurrentInfo = info;
                myCancelUMLCheckBox.setSelection(false);
                
                boolean operatorNameShouldBeSpecified = !operatorHasPredefinedName(info);
                myOperatorNameLabel.setVisible(operatorNameShouldBeSpecified);
                myOperatorNameText.setVisible(operatorNameShouldBeSpecified);
                myOperatorNameText.setText(""); //$NON-NLS-1$
                ((GridData)myOperatorNameLabel.getLayoutData()).exclude = !myOperatorNameLabel.isVisible();
                ((GridData)myOperatorNameText.getLayoutData()).exclude = !myOperatorNameText.isVisible();
                
                myArgumentsLabel.setEnabled(hasArguments(info));
                myArgumentsText.setEnabled(hasArguments(info));
                myArgumentsText.setText(""); //$NON-NLS-1$
                
                myNumberOfOperandsLabel.setEnabled(!hasSingleOperand(info));
                myNumberOfOperandsText.setEnabled(!hasSingleOperand(info));
                myNumberOfOperandsText.setText(hasSingleOperand(info) ? "1":"2"); //$NON-NLS-1$ //$NON-NLS-2$
                
                myCancelUMLPanel.setVisible(isUMLcompliant(info));
                //CR #29549
                ((GridData)myCancelUMLPanel.getLayoutData()).exclude = !myCancelUMLPanel.getVisible();
                this.layout();
            }
            
            void setUMLConstraints(boolean cancel) {
                if (!cancel) {
                    myArgumentsText.setText(""); //$NON-NLS-1$
                    myNumberOfOperandsText.setText(hasSingleOperand(myCurrentInfo) ? "1":"2"); //$NON-NLS-1$ //$NON-NLS-2$
                } 
                myArgumentsLabel.setEnabled(cancel || hasArguments(myCurrentInfo));
                myArgumentsText.setEnabled(cancel || hasArguments(myCurrentInfo));
                
                myNumberOfOperandsLabel.setEnabled(cancel || !hasSingleOperand(myCurrentInfo));
                myNumberOfOperandsText.setEnabled(cancel || !hasSingleOperand(myCurrentInfo));
            }
            
            OperatorProperties getResult() {
                int operandsNumber;
                try {
                    operandsNumber = Integer.parseInt(myNumberOfOperandsText.getText());
                } catch (NumberFormatException e) {
                    operandsNumber = hasSingleOperand(myCurrentInfo) ? 1 : 2;
                }
                OperatorProperties result = new OperatorProperties(myCurrentInfo, myArgumentsText.getText(), operandsNumber);
                return result;
            }
            
            boolean operatorHasPredefinedName(InteractionOperatorKind info) {
                return true;
            }
        }
    }
    
    private static boolean hasSingleOperand(InteractionOperatorKind kind){
    	switch (kind.getValue()){
    		case InteractionOperatorKind.SEQ:
    		case InteractionOperatorKind.ALT:
    		case InteractionOperatorKind.PAR:
    		case InteractionOperatorKind.STRICT:
    			return false;
    			
    		default: 
    			return true;
    	}
    }
    
    private static boolean hasArguments(InteractionOperatorKind kind){
    	switch (kind.getValue()){
			case InteractionOperatorKind.LOOP:
			case InteractionOperatorKind.IGNORE:
			case InteractionOperatorKind.CONSIDER:
				return true;
	    	
			default: 
				return false;
    	}
	}
    
    private static boolean isUMLcompliant(InteractionOperatorKind kind){
    	return true;
    }
}
