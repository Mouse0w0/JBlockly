package com.github.mousesrc.jblockly.fx;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.control.Control;

public class FXBlockWorkspace extends Control implements BlockWorkspaceHolder,Connectable{
	
	private ReadOnlyObjectWrapper<FXBlockWorkspace> workspace = new ReadOnlyObjectWrapper<FXBlockWorkspace>(this, "workspace", this);
	public ReadOnlyObjectProperty<FXBlockWorkspace> workspaceProperty() {return workspace.getReadOnlyProperty();}

	private final ObservableList<FXBlock> blocks = FXCollections.observableArrayList();
	
	private static final String DEFAULT_STYLE_CLASS = "block-workspace";
	
	public FXBlockWorkspace() {
		getStyleClass().addAll(DEFAULT_STYLE_CLASS);
		
		initBlocksListener();
	}
	
	private void initBlocksListener(){
		blocks.addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				requestLayout();
			}
		});
	}
	
	public ObservableList<FXBlock> getBlocks(){
		return blocks;
	}

	@Override
	public boolean connect(FXBlock block, Point2D point) {
		return getBlocks().stream().anyMatch(b->b.connect(block, point.subtract(b.getLayoutX(), b.getLayoutY())));
	}
}
