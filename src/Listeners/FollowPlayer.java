package Listeners;

import Game.GameView;
import city.cs.engine.Body;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class FollowPlayer implements StepListener {
    private GameView view;
    private Body body;

    public FollowPlayer(GameView view, Body body){
        this.view = view;
        this.body = body;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        float x = body.getPosition().x;
        float y = view.getCentre().y;
        view.setCentre(new Vec2(x, y));
    }


}
