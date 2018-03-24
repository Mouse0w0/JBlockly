package com.github.mousesrc.jblockly.demo;

import com.github.mousesrc.jblockly.fx.ConnectionType;
import com.github.mousesrc.jblockly.fx.FXBlock;
import com.github.mousesrc.jblockly.fx.FXBlockRow;
import com.github.mousesrc.jblockly.fx.FXBlockWorkspace;
import com.github.mousesrc.jblockly.fx.FXBlockRow.Type;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Demo extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXBlockWorkspace workspace = new FXBlockWorkspace();
		workspace.setPrefSize(800, 600);
		
		//block1
		FXBlock block1 = new FXBlock();
		
		Label label = new Label("233333333333");
		FXBlockRow blockRow1 = new FXBlockRow();
		blockRow1.setType(Type.INSERT);
		blockRow1.getComponents().addAll(label);
		
		FXBlockRow blockRow2 = new FXBlockRow();
		blockRow2.setType(Type.BRANCH);
		
		FXBlockRow blockRow3 = new FXBlockRow();
		blockRow3.getComponents().addAll(new Label("233333333333"));
		
		FXBlockRow blockRow7 = new FXBlockRow();
		blockRow7.setType(Type.NEXT);
		
		block1.getFXRows().addAll(blockRow1,blockRow2,blockRow3,blockRow7);
		
		//block2
		FXBlock block2 = new FXBlock();
		block2.setConnectionType(ConnectionType.LEFT);
		
		FXBlockRow blockRow4 = new FXBlockRow();
		blockRow4.getComponents().addAll(new Label("233333333333"));
		
		block2.getFXRows().addAll(blockRow4);
		
		//block3
		FXBlock block3 = new FXBlock();
		block3.setConnectionType(ConnectionType.TOP);
		
		FXBlockRow blockRow5 = new FXBlockRow();
		blockRow5.getComponents().addAll(new Label("233333333333"));
		
		FXBlockRow blockRow6 = new FXBlockRow();
		blockRow6.getComponents().addAll(new Label("233333333333"));
	
		block3.getFXRows().addAll(blockRow5,blockRow6);
		
		workspace.getBlocks().addAll(block1,block2,block3);
		
		Scene scene = new Scene(workspace);
		primaryStage.setScene(scene);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setTitle("JBlockly Demo");
		primaryStage.show();
	}

}
