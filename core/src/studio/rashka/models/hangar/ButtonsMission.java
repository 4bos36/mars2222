package studio.rashka.models.hangar;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;
import studio.rashka.lib.FontTTF;
import studio.rashka.lib.Textures;
import studio.rashka.models.lightbulb.GreenLightbulb;

public class ButtonsMission {

    private Stage stageMissions;
    private GreenLightbulb greenLightbulb;

    private Map<String, Label> text;
    private int page;

    public ButtonsMission(int page) {
        this.page = page;
        stageMissions = new Stage();
        greenLightbulb = new GreenLightbulb();

        text = new HashMap<String, Label>();
        text.put("Mission-1", new Label("", new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE)));
        text.put("Mission-2", new Label("", new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE)));
        text.put("Mission-3", new Label("", new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE)));
        text.put("Mission-4", new Label("", new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE)));
        text.put("Mission-5", new Label("", new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE)));
        text.put("Mission-6", new Label("", new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE)));

        stageMissions.addActor(text.get("Mission-1"));
        stageMissions.addActor(text.get("Mission-2"));
        stageMissions.addActor(text.get("Mission-3"));
        stageMissions.addActor(text.get("Mission-4"));
        stageMissions.addActor(text.get("Mission-5"));
        stageMissions.addActor(text.get("Mission-6"));
    }

    public void textLoad() {
        if (page == 1) {
            //region code
            text.get("Mission-1").setText(MarsGame.getLanguage().textScreen.get("Mission-1-1"));
            if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) text.get("Mission-2").setText(MarsGame.getLanguage().textScreen.get("Mission-1-2"));
            else text.get("Mission-2").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_1_2")) text.get("Mission-3").setText(MarsGame.getLanguage().textScreen.get("Mission-1-3"));
            else text.get("Mission-3").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_1_3")) text.get("Mission-4").setText(MarsGame.getLanguage().textScreen.get("Mission-1-4"));
            else text.get("Mission-4").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_1_4")) text.get("Mission-5").setText(MarsGame.getLanguage().textScreen.get("Mission-1-5"));
            else text.get("Mission-5").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_1_5")) text.get("Mission-6").setText(MarsGame.getLanguage().textScreen.get("Mission-1-6"));
            else text.get("Mission-6").setText("");
            //endregion
        } else if (page == 2) {
            //region code
            if (MarsGame.getPreference().loadMissionFinish("Missions_1_6")) text.get("Mission-1").setText(MarsGame.getLanguage().textScreen.get("Mission-2-1"));
            else text.get("Mission-1").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_2_1")) text.get("Mission-2").setText(MarsGame.getLanguage().textScreen.get("Mission-2-2"));
            else text.get("Mission-2").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_2_2")) text.get("Mission-3").setText(MarsGame.getLanguage().textScreen.get("Mission-2-3"));
            else text.get("Mission-3").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_2_3")) text.get("Mission-4").setText(MarsGame.getLanguage().textScreen.get("Mission-2-4"));
            else text.get("Mission-4").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_2_4")) text.get("Mission-5").setText(MarsGame.getLanguage().textScreen.get("Mission-2-5"));
            else text.get("Mission-5").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_2_5")) text.get("Mission-6").setText(MarsGame.getLanguage().textScreen.get("Mission-2-6"));
            else text.get("Mission-6").setText("");
            //endregion
        } else if (page == 3) {
            //region code
            if (MarsGame.getPreference().loadMissionFinish("Missions_2_6")) text.get("Mission-1").setText(MarsGame.getLanguage().textScreen.get("Mission-3-1"));
            else text.get("Mission-1").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_3_1")) text.get("Mission-2").setText(MarsGame.getLanguage().textScreen.get("Mission-3-2"));
            else text.get("Mission-2").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_3_2")) text.get("Mission-3").setText(MarsGame.getLanguage().textScreen.get("Mission-3-3"));
            else text.get("Mission-3").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_3_3")) text.get("Mission-4").setText(MarsGame.getLanguage().textScreen.get("Mission-3-4"));
            else text.get("Mission-4").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_3_4")) text.get("Mission-5").setText(MarsGame.getLanguage().textScreen.get("Mission-3-5"));
            else text.get("Mission-5").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_3_5")) text.get("Mission-6").setText(MarsGame.getLanguage().textScreen.get("Mission-3-6"));
            else text.get("Mission-6").setText("");
            //endregion
        } else if (page == 4) {
            //region code
            if (MarsGame.getPreference().loadMissionFinish("Missions_3_6")) text.get("Mission-1").setText(MarsGame.getLanguage().textScreen.get("Mission-4-1"));
            else text.get("Mission-1").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_4_1")) text.get("Mission-2").setText(MarsGame.getLanguage().textScreen.get("Mission-4-2"));
            else text.get("Mission-2").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_4_2")) text.get("Mission-3").setText(MarsGame.getLanguage().textScreen.get("Mission-4-3"));
            else text.get("Mission-3").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_4_3")) text.get("Mission-4").setText(MarsGame.getLanguage().textScreen.get("Mission-4-4"));
            else text.get("Mission-4").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_4_4")) text.get("Mission-5").setText(MarsGame.getLanguage().textScreen.get("Mission-4-5"));
            else text.get("Mission-5").setText("");
            if (MarsGame.getPreference().loadMissionFinish("Missions_4_5")) text.get("Mission-6").setText(MarsGame.getLanguage().textScreen.get("Mission-4-6"));
            else text.get("Mission-6").setText("");
            //endregion
        } else if (page == 5) {
            //region code
            text.get("Mission-1").setText("");
            text.get("Mission-2").setText(MarsGame.getLanguage().textScreen.get("ComingSoon"));
            text.get("Mission-3").setText(MarsGame.getLanguage().textScreen.get("ComingSoon2"));
            text.get("Mission-4").setText("");
            text.get("Mission-5").setText("");
            text.get("Mission-6").setText("");
            //endregion
        }

        text.get("Mission-1").setPosition(737 * MarsGame.getRatioMonitorW() - text.get("Mission-1").getPrefWidth() / 2, (575 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Mission-2").setPosition(957 * MarsGame.getRatioMonitorW() - text.get("Mission-2").getPrefWidth() / 2, (575 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Mission-3").setPosition(1177 * MarsGame.getRatioMonitorW() - text.get("Mission-3").getPrefWidth() / 2, (575 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Mission-4").setPosition(737 * MarsGame.getRatioMonitorW() - text.get("Mission-4").getPrefWidth() / 2, (355 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Mission-5").setPosition(957 * MarsGame.getRatioMonitorW() - text.get("Mission-5").getPrefWidth() / 2, (355 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Mission-6").setPosition(1177 * MarsGame.getRatioMonitorW() - text.get("Mission-6").getPrefWidth() / 2, (355 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        if (page == 5) {
            //region code
            text.get("Mission-2").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Mission-2").getPrefWidth() / 2, (575 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            text.get("Mission-3").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Mission-3").getPrefWidth() / 2, (355 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            //endregion
        }
    }

    private void missions_1(SpriteBatch batch) {
        //region Button 1
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_1_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_1_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_1_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_1_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        //endregion
        //region Button 2
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_1_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_1_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_1_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_1_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 3
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_1_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_1_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_1_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_1_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_1_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 4
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_1_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_1_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_1_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_1_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_1_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 640 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 5
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_1_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_1_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_1_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_1_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_1_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 6
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_1_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_1_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_1_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_1_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_1_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
    }

    private void missions_2(SpriteBatch batch) {
        //region Button 1
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_2_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_2_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_2_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_2_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_1_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 640 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 2
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_2_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_2_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_2_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_2_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_2_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 3
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_2_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_2_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_2_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_2_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_2_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 4
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_2_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_2_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_2_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_2_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_2_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 640 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 5
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_2_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_2_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_2_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_2_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_2_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 6
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_2_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_2_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_2_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_2_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_2_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
    }

    private void missions_3(SpriteBatch batch) {
        //region Button 1
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_3_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_3_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_3_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_3_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_2_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 640 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 2
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_3_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_3_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_3_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_3_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_3_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 3
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_3_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_3_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_3_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_3_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_3_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 4
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_3_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_3_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_3_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_3_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_3_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 640 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 5
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_3_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_3_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_3_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_3_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_3_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 6
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_3_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_3_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_3_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_3_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_3_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
    }

    private void missions_4(SpriteBatch batch) {
        //region Button 1
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_4_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_4_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_4_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_4_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_3_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 640 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 2
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_4_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_4_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_4_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_4_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_4_1")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 3
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 480 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_4_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_4_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 480 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_4_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 480 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 480 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_4_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 480 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 480 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_4_2")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 480 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 480 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 4
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 640, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_4_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 640 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 640 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_4_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 640 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 640 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_4_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 640 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 640 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_4_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 640 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 640 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_4_3")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 640 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 640 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 5
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 860, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_4_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 860 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 860 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_4_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 860 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 860 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_4_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 860 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 860 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_4_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 860 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 860 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_4_4")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 860 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 860 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
        //region Button 6
        batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonsMission"), 1080, 260 + MarsGame.getRatioAdd());
        if (!MarsGame.getPreference().loadMissionFinish("Missions_4_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionRed"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, 1080 + 14, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionLife("Missions_4_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionBlue"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, 1080 + 166, 260 + MarsGame.getRatioAdd() + 170, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionMineral("Missions_4_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionGreen"), 1080 + 15, 260 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, 1080 + 15, 260 + MarsGame.getRatioAdd() + 11, 12, 12);
        }
        if (!MarsGame.getPreference().loadMissionSecret("Missions_4_6")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNONE"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
        else {
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionTurquoise"), 1080 + 176, 260 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, 1080 + 165, 260 + MarsGame.getRatioAdd() + 12, 12, 12);
        }
        if (MarsGame.getPreference().loadMissionFinish("Missions_4_5")) batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonMissionNumber"), 1080 + 64, 260 + MarsGame.getRatioAdd() + 64, 32, 32, 64, 64, 1, 1, 45);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("Lock"), 1080 + 48, 260 + MarsGame.getRatioAdd() + 48, 96, 96);
        //endregion
    }

    private void render(SpriteBatch batch) {
        if (page == 1) missions_1(batch);
        else if (page == 2) missions_2(batch);
        else if (page == 3) missions_3(batch);
        else if (page == 4) missions_4(batch);
    }

    public void updateButtonMission(float deltaTime) {
        greenLightbulb.update(deltaTime);
    }

    public void renderButtonMission(SpriteBatch batch) {
        render(batch);
    }

    public Stage getStageMissions() {
        return stageMissions;
    }

    public Label getText(String name) {
        return text.get(name);
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void dispose() {
        try {
            stageMissions.dispose();
            text.clear();
            greenLightbulb.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}