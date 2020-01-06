package Ex2Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.Vertex;
import dataStructure.graph;
import gui.Graph_GUI;
import utils.Point3D;

class guiTest {

	@Test
	void test() {
		graph graph = new DGraph();
		
		graph.addNode(new Vertex(0,new Point3D(48,7)));
        graph.addNode(new Vertex(1,new Point3D(2,2)));
        graph.addNode(new Vertex(2,new Point3D(4,24)));
        graph.addNode(new Vertex(3,new Point3D(6,3)));
        graph.addNode(new Vertex(4,new Point3D(1,18)));
        graph.connect(0,3,58);
        graph.connect(0,4,0);
        graph.connect(1,0,647);
        graph.connect(1,3,6);
        graph.connect(2,1,38);
        graph.connect(3,4,57.8);
        graph.connect(3,2,1.5);
        graph.connect(4,3,8);
        
        Graph_GUI gui = new Graph_GUI(graph);
	}

}
