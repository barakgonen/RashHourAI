package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import search_engine.astar.AStarSearchNode;

class TestIdentifyingBoards {
	@Test
	void testTwoAStarSearchNodesHasTheSameHashCode() {
		AStarSearchNode s1 = TestsUtils.getSearchNode();
		AStarSearchNode s2 = TestsUtils.getSearchNode();
		assertEquals(s1, s2);
		assertEquals(s1.getUUID(), s2.getUUID());
	}
}
