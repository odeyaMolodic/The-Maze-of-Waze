package Ex2Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructure.*;
import utils.Point3D;

class DGraphTest {

	DGraph graph;
	
    @BeforeEach
    void init(){
        graph = new DGraph();
    }
    
    @Test
    void getNode() {
    	graph.addNode(new Vertex(13,new Point3D(2,2)));
        graph.getNode(13);
    }

    @org.junit.jupiter.api.Test
    void getEdge() {
        graph.addNode(new Vertex(10,new Point3D(0,0)));
        graph.addNode(new Vertex(13,new Point3D(2,2)));
        try {
        	graph.connect(10,13,0);
        } catch (RuntimeException e) {
        	e.printStackTrace();
        }
        graph.getEdge(10,13);
    }

    @Test
    void removeNode() {
    	graph.addNode(new Vertex(10,new Point3D(0,0)));
        graph.addNode(new Vertex(11,new Point3D(2,2)));
        graph.addNode(new Vertex(12,new Point3D(4,4)));
        graph.addNode(new Vertex(13,new Point3D(3,3)));
        graph.addNode(new Vertex(14,new Point3D(1,1)));
        graph.connect(10,13,0);
        graph.connect(10,14,0);
        graph.connect(11,10,0);
        graph.connect(11,13,0);
        graph.connect(12,11,0);
        graph.connect(13,14,1);
        graph.connect(13,12,1.5);
        graph.connect(14,13,0);
        graph.removeNode(12);
        assertEquals(4, graph.nodeSize());
        assertEquals(6,graph.edgeSize());
       
    }

    @Test
    void removeEdge() {
    	graph.addNode(new Vertex(10,new Point3D(0,0)));
        graph.addNode(new Vertex(11,new Point3D(2,2)));
        graph.connect(10,11,0);
        graph.removeEdge(10,11);
        graph.getE(10);
        assertEquals(0,graph.getE(10).size());
    }

    @Test
    void MC_Size() {
    	graph.addNode(new Vertex(10,new Point3D(0,0)));
        graph.addNode(new Vertex(11,new Point3D(2,2)));
        graph.addNode(new Vertex(12,new Point3D(4,4)));
        graph.addNode(new Vertex(13,new Point3D(3,3)));
        graph.addNode(new Vertex(14,new Point3D(1,1)));        
        graph.connect(10,13,0); 
        graph.connect(10,14,0);
        graph.connect(11,10,0);
        graph.connect(11,13,0);
        graph.connect(12,11,0);
        graph.connect(13,14,1);
        graph.connect(13,12,1.5);
        graph.connect(14,13,0);
        assertEquals(5,graph.nodeSize());
        assertEquals(8,graph.edgeSize());
        assertEquals(13,graph.getMC());
    }


}
