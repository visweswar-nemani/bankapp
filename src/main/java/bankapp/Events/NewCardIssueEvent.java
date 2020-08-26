package bankapp.Events;

import org.springframework.context.ApplicationEvent;

import bankapp.DAO.CardData;

public class NewCardIssueEvent extends ApplicationEvent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardData cardData;
	
	public NewCardIssueEvent(Object source,CardData cardData) {
		super(source);
		this.cardData=cardData;
		// TODO Auto-generated constructor stub
	}

}
