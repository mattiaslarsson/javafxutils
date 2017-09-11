# javafxutils
## Utilities for JavaFX Applications

- Extend the class JavaFXUtils
- Declare your Nodes as fields and annotate them with <code>@Draggable</code>
- Annotate a <code>Scene</code> with <code>@Scalable(mouse = true)</code> to enable scale by mousewheel
- Override the method <code>instantiateFields()</code> where you instantiate your nodes
- In the method <code>start(Stage primaryStage)</code> you call <code>super.run(this)</code>
- Then you can make your Parent, Scene and Stage as usual

