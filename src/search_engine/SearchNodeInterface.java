package search_engine;

import java.util.Set;

/**
 * This interface defines how do search node should be represented
 *
 */
public interface SearchNodeInterface {

	/**
	 * Tests weather this node is the goal node
	 * 
	 * @return
	 */
	boolean isGoalNode();

	/**
	 * Function to get next available states, each node should know how to expand
	 * itself
	 * 
	 * @return
	 */
	Set<SearchNodeInterface> getSuccessors();

	// Should be 3rd. func to get current state
}
