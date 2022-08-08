package model;

import java.util.ArrayList;

import utils.StateType;

public class NDFA {
	private ArrayList<State> states;
	private ArrayList<Transition> transitions;

	private ArrayList<ArrayList<Transition>> statesTransitions;
	private  ArrayList<State> currentStates;

	public NDFA() {
		states=new ArrayList<State>();
		transitions=new ArrayList<Transition>();
	}

	public void addState(String name, StateType type) {
		states.add(new State(name,type));
	}

	public void deleteState(State state) {
		states.remove(state);
	}

	public void addTransition(char transitionValue, State initialState, State finalState) {
		transitions.add(new Transition(transitionValue,initialState,finalState));
	}

	public void deleteTransition(Transition transition) {
		transitions.remove(transition);
	}

	public boolean validateWord(String word) {
		boolean validation = false;
		String[] splitWord = word.split(""); 
		this.statesTransitions = new ArrayList<ArrayList<Transition>>();
		statesTransitions.add(searchTransitions(this.states.get(0)));
		this.currentStates = new ArrayList<State>();
		currentStates.add(statesTransitions.get(0).get(0).getInitialState());

		for(int i = 0; i<splitWord.length; i++){
			validation = validateCaracter(splitWord[i]);
			if(validation == false){
				return validation;
			}
		}
		for(int i = 0; i < currentStates.size(); i++){
			if(currentStates.get(i).getType().equals(StateType.FINAL)){
				validation = true;
				break;
			}else{
				validation = false;
			}
		}

		return validation;
	}

	public boolean validateCaracter(String caracter){
		boolean validation = false;
		this.currentStates = new ArrayList<State>();
		for(int i = 0; i < statesTransitions.size(); i++){
			ArrayList<Transition> stateTransitions = statesTransitions.get(i);
			for(int j = 0; j < stateTransitions.size(); j++){
				if(caracter.compareTo(String.valueOf(stateTransitions.get(j).getTransitionValue())) == 0 ){
					currentStates.add(stateTransitions.get(j).getFinalState());
				}
			}
		}
		fillStatesTransitions();
		if(currentStates.isEmpty() == false){
			validation = true;
		}
		else{
			validation = false;
		}

		return validation;
	}

	private void fillStatesTransitions(){
		this.statesTransitions = new ArrayList<ArrayList<Transition>>();
		for(int i = 0; i < this.currentStates.size(); i++){
			statesTransitions.add(searchTransitions(currentStates.get(i)));
		}
	}

	public ArrayList<Transition> searchTransitions(State state){
		ArrayList<Transition> stateTransitions = new ArrayList<Transition>();
		for(int i = 0; i < this.transitions.size(); i++){
			if(transitions.get(i).getInitialState().getName().equals(state.getName())){
				stateTransitions.add(transitions.get(i));
			}
		}
		return stateTransitions;
	}

	public int getStateIndex(String stateName){
		int index = 0;
		for(int i = 0; i < states.size() ;i++){
			if(states.get(i).getName().compareTo(stateName) == 0){
				index = i;
			}
		}
		return index;
	}

	public ArrayList<State> getStates(){
		return this.states;
	}

	public ArrayList<Transition> gTransitions(){
		return this.transitions;
	}
}
