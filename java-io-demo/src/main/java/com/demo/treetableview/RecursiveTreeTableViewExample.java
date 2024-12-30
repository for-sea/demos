package com.demo.treetableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecursiveTreeTableViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建TreeTableView
        TreeTableView<Item> treeTableView = new TreeTableView<>();

        // 创建列
        TreeTableColumn<Item, String> nameColumn = new TreeTableColumn<>("Name");
        nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(150);

        TreeTableColumn<Item, String> descriptionColumn = new TreeTableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("description"));
        descriptionColumn.setPrefWidth(250);

        // 将列添加到TreeTableView
        treeTableView.getColumns().addAll(nameColumn, descriptionColumn);

        // 创建根节点
        TreeItem<Item> root = new TreeItem<>(new Item("Root", "Root item"));
        root.setExpanded(true); // 默认展开

        // 使用递归创建节点层级结构
        int maxDepth = 3;      // 树的深度
        int numChildren = 2;   // 每个节点的子节点数量
        createTreeItems(root, maxDepth, numChildren, 1);

        // 设置根节点
        treeTableView.setRoot(root);
        treeTableView.setShowRoot(true); // 显示根节点

        // 布局
        VBox vbox = new VBox(treeTableView);
        Scene scene = new Scene(vbox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Recursive TreeTableView Example");
        primaryStage.show();
    }

    // 递归方法创建TreeItem节点
    private void createTreeItems(TreeItem<Item> parent, int depth, int numChildren, int level) {
        // 基础条件：当层级深度为0时停止递归
        if (depth == 0) return;

        for (int i = 1; i <= numChildren; i++) {
            // 创建当前层的节点
            TreeItem<Item> child = new TreeItem<>(new Item("Node " + level + "." + i, "Node at level " + level));
            parent.getChildren().add(child);

            // 递归创建子节点，深度减1，层级数加1
            createTreeItems(child, depth - 1, numChildren, level + 1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    // 定义Item类
    public static class Item {
        private String name;
        private String description;

        public Item(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}
