package org.pasut.games.guerra.domain.visibility;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.pasut.games.guerra.domain.unit.visibility.AllwaysVisibleVisibility;
import org.pasut.games.guerra.domain.unit.visibility.BasicVisibility;
import org.pasut.games.guerra.domain.unit.visibility.VisibilityType;
import org.pasut.persister.MongoPersisterService;
import org.pasut.persister.PersisterService;
import org.pasut.persister.operators.Equal;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class VisibilityTest {
	private PersisterService mongo;
	@Before
	public void setUp() throws Exception {
		mongo = new MongoPersisterService("guerras-test", "localhost", 27017);
		DB db = new Mongo("localhost", 27017).getDB("guerras-test");
		DBCollection testCollection = db.getCollection("test");
		testCollection.drop();
	}
	
	@Test
	public void testBasic() {
		BasicVisibility v = new BasicVisibility(-34,-58,10,1);
		BasicVisibility v2 = VisibilityType.build(v);
		assertEquals(v, v2);
	}
	
	@Test
	public void testAllways() throws InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException{
		BasicVisibility v = new AllwaysVisibleVisibility(-34,-58);
		mongo.insert(v);
		v = mongo.find(BasicVisibility.class, new Equal("level", 1)).get(0);
		
//		BasicVisibility v = mock(BasicVisibility.class);
//		when(v.getType()).thenReturn(VisibilityType.ALLWAYS);
		BasicVisibility v2 = VisibilityType.build(v);
		assertEquals(v, v2);
	}
	

}
