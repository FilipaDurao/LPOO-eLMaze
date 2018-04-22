package com.mygdx.elmaze.view.entities;

import java.util.HashMap;

import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class ViewFactory {

	private static HashMap<EntityModel, EntityView> viewCache = new HashMap<EntityModel, EntityView>();

    public static EntityView makeView(ELMaze  game, EntityModel model) {
        if (!viewCache.containsKey(model)) {
            if (model instanceof BallModel) {
            	viewCache.put(model, new BallView(game, (BallModel) model));
            }
            else if (model instanceof ButtonModel) {
            	viewCache.put(model, new ButtonView(game, (ButtonModel) model));
            }
            else if (model instanceof DoorModel) {
            	viewCache.put(model, new DoorView(game, (DoorModel) model));
            }
            else if (model instanceof ExitModel) {
            	viewCache.put(model, new ExitView(game, (ExitModel) model));
            }
            else if (model instanceof WallModel) {
            	viewCache.put(model, new WallView(game, (WallModel) model));
            }
        }
        
        return viewCache.get(model);
    }
}
