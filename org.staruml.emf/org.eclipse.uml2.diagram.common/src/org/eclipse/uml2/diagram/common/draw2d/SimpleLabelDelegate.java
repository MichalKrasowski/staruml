package org.eclipse.uml2.diagram.common.draw2d;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.swt.graphics.Image;


public class SimpleLabelDelegate extends ILabelDelegate.Stub {
        private Label myLabel;
        private boolean myIsSelected;

        public SimpleLabelDelegate(Label label) {
            myLabel = label;
        }

        @Override
		public void setFocus(boolean b) {
            //not supported
        }

        @Override
		public void setSelected(boolean selected) {
            //ui effect not supported
        	myIsSelected = selected;
        }

        @Override
		public String getText() {
            return myLabel.getText();
        }

        @Override
		public void setIcon(Image image, int index) {
            if (index == 0) {
                myLabel.setIcon(image);
            }
        }

        @Override
		public void setAlignment(int right) {
            myLabel.setLabelAlignment(right);
        }

        @Override
		public void setText(String text) {
            myLabel.setText(text);
        }

        @Override
		public void setTextAlignment(int alignment) {
            myLabel.setTextAlignment(alignment);
        }

        @Override
		public void setIconAlignment(int alignment) {
            myLabel.setIconAlignment(alignment);
        }

        @Override
		public Rectangle getTextBounds() {
            Rectangle rect = myLabel.getTextBounds().getCopy();
            myLabel.translateToAbsolute(rect);
            return rect;
        }

        @Override
		public void setTextPlacement(int placement) {
            myLabel.setTextPlacement(placement);
        }

        @Override
		public void setTextStrikeThrough(boolean strikeThrough) {
            //not supported
        }

        @Override
		public void setTextUnderline(boolean underline) {
            //not supported
        }

        @Override
		public Image getIcon(int index) {
            if (index == 0) {
                return myLabel.getIcon();
            }
            return null;
        }

        @Override
		public int getIconAlignment() {
            return myLabel.getIconAlignment();
        }

        @Override
		public int getTextAlignment() {
            return myLabel.getTextAlignment();
        }

        @Override
		public int getTextPlacement() {
            return myLabel.getTextPlacement();
        }

        @Override
		public boolean hasFocus() {
            return myLabel.hasFocus();
        }

        @Override
		public boolean isSelected() {
            return myIsSelected;
        }

        @Override
		public boolean isTextStrikedThrough() {
            return false;
        }

        @Override
		public boolean isTextUnderlined() {
            return false;
        }

    }
