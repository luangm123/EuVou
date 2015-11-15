package dao;

import android.app.Activity;

import org.json.JSONObject;

import model.Evaluation;
import model.EventEvaluation;

/**
 * Created by marlonmendes on 15/11/15.
 */
public class EventEvaluationDAO extends DAO {
    public EventEvaluationDAO() {}

    public EventEvaluationDAO(Activity activity) {
        super(activity);
    }
    public void evaluateEvent(EventEvaluation evaluation) {
        final String QUERY;

        JSONObject findEvaluation = executeConsult("SELECT * FROM evaluate_event WHERE idEvent = \""
                                                   + evaluation.getEventId() + "\" "
                                                   + "AND idUser = \"" + evaluation.getUserId() + "\"");

        if(findEvaluation==null) {
            QUERY = "INSERT INTO evaluate_event(grade, idUser, idEvent) VALUES (\"" + evaluation.getRating() + "\"," +
                    "\"" + evaluation.getUserId() + "\"," +
                    "\"" + evaluation.getEventId() + "\")";
        }else{
            QUERY = "UPDATE evaluate_event SET grade = \"" +evaluation.getRating() + "\" " +
                    "WHERE idEvent = \"" + evaluation.getEventId() + "\" AND idUser = \"" + evaluation.getUserId() + "\"";
        }

        executeQuery(QUERY);
    }
}
