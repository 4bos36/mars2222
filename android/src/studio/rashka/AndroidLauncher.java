package studio.rashka;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import studio.rashka.mars2222.R;


public class AndroidLauncher extends AndroidApplication implements RewardedVideoAdListener,
        PurchasesUpdatedListener, PurchaseHistoryResponseListener, ConsumeResponseListener, SkuDetailsResponseListener,
        PlayServices, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Map<String, RewardedVideoAd> videoAd;
    private int loadVideo = 0;
    private Preferences setting;
    private DisplayRatio displayRatio;
    private boolean isConnect;

    private BillingClient billingClient;
    private GoogleApiClient googleApiClient;

    // Are we currently resolving a connection failure?
    private boolean resolvingConnectionFailure = false;

    // Set to true to automatically start the sign in flow when the Activity starts.
    // Set to false to require the user to click the button in order to sign in.
    private boolean autoStartSignInflow = true;

    // Has the user clicked the sign-in button?
    private boolean signInClicked = false;

    // Request code used to invoke sign in user interactions.
    private static final int RC_SIGN_IN = 9001;
    // Request code to use when launching the resolution activity
    private static final int REQUEST_RESOLVE_ERROR = 1001;
    // Unique tag for the error dialog fragment
    private static final String DIALOG_ERROR = "dialog_error";

    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                //region Ads
                case 1:
                    if (videoAd.get("Money").isLoaded()) {
                        videoAd.get("Money").show();
                        loadVideo = 1;
                    }
                    break;
                case 2:
                    if (videoAd.get("Mineral").isLoaded()) {
                        videoAd.get("Mineral").show();
                        loadVideo = 2;
                    }
                    break;
                case 3:
                    if (videoAd.get("ShieldHPAdd").isLoaded()) {
                        videoAd.get("ShieldHPAdd").show();
                        loadVideo = 3;
                    }
                    break;
                case 4:
                    if (videoAd.get("EnergyAdd").isLoaded()) {
                        videoAd.get("EnergyAdd").show();
                        loadVideo = 4;
                    }
                    break;
                case 5:
                    if (videoAd.get("Microwave").isLoaded()) {
                        videoAd.get("Microwave").show();
                        loadVideo = 5;
                    }
                    break;
                case 404:
                    if (!videoAd.get("Money").isLoaded()) loadVideoAd();
                    break;
                //endregion
                //region MONEY
                case 6:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMONEY()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 11:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMoney2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 12:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMoney3()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 13:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMoney4()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 14:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMoney5()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                //endregion
                //region MINERAL
                case 7:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMINERAL()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 15:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMineral2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 16:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMineral3()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 17:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMineral4()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 18:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMineral5()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                //endregion
                //region ShieldHPAdd
                case 8:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getSHIELDHPADD()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 19:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getShieldhpadd2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 20:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getShieldhpadd3()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 21:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getShieldhpadd4()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 22:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getShieldhpadd5()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                //endregion
                //region EnergyAdd
                case 9:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getENERGYADD()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 23:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getEnergyadd2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 24:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getEnergyadd2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 25:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getEnergyadd2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 26:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getEnergyadd2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                //endregion
                //region Microwave
                case 10:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMICROWAVE()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 27:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMicrowave2()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 28:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMicrowave3()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 29:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMicrowave4()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                case 30:
                    BillingFlowParams.newBuilder().setSku(InAppBillingResources.getMicrowave5()).setType(BillingClient.SkuType.INAPP).build();
                    break;
                //endregion
                case 200:
                    if (isConnect) {
                        loadProductPrice();
                        System.out.println("Start load 200");
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // не даёт тухнуть экрану
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        super.onCreate(savedInstanceState);

        RelativeLayout layout = new RelativeLayout(this);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;

        // Create the Google Api Client with access to the Play Games services
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Games.API)
                .addScope(Games.SCOPE_GAMES_LITE)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        View gameView = initializeForView(new MarsGame(this), config);
        layout.addView(gameView);
        setContentView(layout);

        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, "9KQ6PCWJV4PR3ZYKJ949");

        setting = Gdx.app.getPreferences("Pref_Mars2222");
        displayRatio = new DisplayRatio(getWindowManager(), setting);
        videoAd = new HashMap<>();

        //region AdsVideo
        MobileAds.initialize(this, getString(R.string.admob_app_id));

        videoAd.put("Money", MobileAds.getRewardedVideoAdInstance(this));
        videoAd.get("Money").setRewardedVideoAdListener(this);

        videoAd.put("Mineral", MobileAds.getRewardedVideoAdInstance(this));
        videoAd.get("Mineral").setRewardedVideoAdListener(this);

        videoAd.put("ShieldHPAdd", MobileAds.getRewardedVideoAdInstance(this));
        videoAd.get("ShieldHPAdd").setRewardedVideoAdListener(this);

        videoAd.put("EnergyAdd", MobileAds.getRewardedVideoAdInstance(this));
        videoAd.get("EnergyAdd").setRewardedVideoAdListener(this);

        videoAd.put("Microwave", MobileAds.getRewardedVideoAdInstance(this));
        videoAd.get("Microwave").setRewardedVideoAdListener(this);
//		loadVideoAd();
        //endregion
        //region Pay
        billingClient = BillingClient.newBuilder(this).setListener(this).build();
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(int responseCode) {
                System.out.println("onBillingSetupFinished " + responseCode);
                if (responseCode == BillingClient.BillingResponse.OK) {
                    System.out.println("onBillingSetupFinished OK");
                    isConnect = true;
                } else {
                    isConnect = false;
                    setting.putBoolean("isBuy", false);
                    setting.flush();
                    billingClient.endConnection();
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                System.out.println("onBillingSetupFinished FALSE");
                isConnect = false;
                setting.putBoolean("isBuy", false);
                setting.flush();
                billingClient.endConnection();
            }
        });
        //endregion
    }

    private void loadVideoAd() {
        if (loadVideo == 0) {
            videoAd.get("Money").loadAd("ca-app-pub-4502192705853513/3632456312", new AdRequest.Builder().build());
            videoAd.get("Mineral").loadAd("ca-app-pub-4502192705853513/5631933697", new AdRequest.Builder().build());
            videoAd.get("ShieldHPAdd").loadAd("ca-app-pub-4502192705853513/7886508040", new AdRequest.Builder().build());
            videoAd.get("EnergyAdd").loadAd("ca-app-pub-4502192705853513/9020514364", new AdRequest.Builder().build());
            videoAd.get("Microwave").loadAd("ca-app-pub-4502192705853513/9543258546", new AdRequest.Builder().build());
        } else if (loadVideo == 1)
            videoAd.get("Money").loadAd("ca-app-pub-4502192705853513/3632456312", new AdRequest.Builder().build());
        else if (loadVideo == 2)
            videoAd.get("Mineral").loadAd("ca-app-pub-4502192705853513/5631933697", new AdRequest.Builder().build());
        else if (loadVideo == 3)
            videoAd.get("ShieldHPAdd").loadAd("ca-app-pub-4502192705853513/7886508040", new AdRequest.Builder().build());
        else if (loadVideo == 4)
            videoAd.get("EnergyAdd").loadAd("ca-app-pub-4502192705853513/9020514364", new AdRequest.Builder().build());
        else if (loadVideo == 5)
            videoAd.get("Microwave").loadAd("ca-app-pub-4502192705853513/9543258546", new AdRequest.Builder().build());
    }

    private void loadProductPrice() {
        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder()
                .setSkusList(InAppBillingResources.getListProduct())
                .setType(BillingClient.SkuType.INAPP);
        billingClient.querySkuDetailsAsync(params.build(), this);
    }

    @Override
    public void onBackPressed() { // кнопка назад

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) { // скрываем панель навигации
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.KEEP_SCREEN_ON);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void showAds(final int show) {
        handler.sendEmptyMessage(show);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        if (autoStartSignInflow)
//            googleApiClient.connect();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            videoAd.get("Money").resume(this);
            videoAd.get("Mineral").resume(this);
            videoAd.get("ShieldHPAdd").resume(this);
            videoAd.get("EnergyAdd").resume(this);
            videoAd.get("Microwave").resume(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            videoAd.get("Money").pause(this);
            videoAd.get("Mineral").pause(this);
            videoAd.get("ShieldHPAdd").pause(this);
            videoAd.get("EnergyAdd").pause(this);
            videoAd.get("Microwave").pause(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            videoAd.get("Money").destroy(this);
            videoAd.get("Mineral").destroy(this);
            videoAd.get("ShieldHPAdd").destroy(this);
            videoAd.get("EnergyAdd").destroy(this);
            videoAd.get("Microwave").destroy(this);
            if (billingClient.isReady()) billingClient.endConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
    }

    @Override
    public void onRewardedVideoAdOpened() {
    }

    @Override
    public void onRewardedVideoStarted() {
    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        if (loadVideo == 1) {
            setting.putInteger("Money", setting.getInteger("Money") + 1000);
            setting.flush();
        } else if (loadVideo == 2) {
            setting.putInteger("Mineral", setting.getInteger("Mineral") + 20);
            setting.flush();
        } else if (loadVideo == 3) {
            setting.putInteger("ShieldHPAdd", setting.getInteger("ShieldHPAdd") + 1);
            setting.flush();
        } else if (loadVideo == 4) {
            setting.putInteger("EnergyAdd", setting.getInteger("EnergyAdd") + 1);
            setting.flush();
        } else if (loadVideo == 5) {
            setting.putInteger("Microwave", setting.getInteger("Microwave") + 1);
            setting.flush();
        }
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @Override
    public void onPurchasesUpdated(int responseCode, @Nullable List<Purchase> purchases) {
        if (responseCode == BillingClient.BillingResponse.OK) {
            for (Purchase product : purchases) {
                String name = product.getSku();

                if (name.equals(InAppBillingResources.getMONEY()))
                    setting.putInteger("Money", setting.getInteger("Money") + 5000);
                else if (name.equals(InAppBillingResources.getMoney2()))
                    setting.putInteger("Money", setting.getInteger("Money") + 11500);
                else if (name.equals(InAppBillingResources.getMoney3()))
                    setting.putInteger("Money", setting.getInteger("Money") + 18000);
                else if (name.equals(InAppBillingResources.getMoney4()))
                    setting.putInteger("Money", setting.getInteger("Money") + 25000);
                else if (name.equals(InAppBillingResources.getMoney5()))
                    setting.putInteger("Money", setting.getInteger("Money") + 50000);

                else if (name.equals(InAppBillingResources.getMINERAL()))
                    setting.putInteger("Mineral", setting.getInteger("Mineral") + 250);
                else if (name.equals(InAppBillingResources.getMineral2()))
                    setting.putInteger("Mineral", setting.getInteger("Mineral") + 500);
                else if (name.equals(InAppBillingResources.getMineral3()))
                    setting.putInteger("Mineral", setting.getInteger("Mineral") + 850);
                else if (name.equals(InAppBillingResources.getMineral4()))
                    setting.putInteger("Mineral", setting.getInteger("Mineral") + 1500);
                else if (name.equals(InAppBillingResources.getMineral5()))
                    setting.putInteger("Mineral", setting.getInteger("Mineral") + 3000);

                else if (name.equals(InAppBillingResources.getSHIELDHPADD()))
                    setting.putInteger("ShieldHPAdd", setting.getInteger("ShieldHPAdd") + 5);
                else if (name.equals(InAppBillingResources.getShieldhpadd2()))
                    setting.putInteger("ShieldHPAdd", setting.getInteger("ShieldHPAdd") + 10);
                else if (name.equals(InAppBillingResources.getShieldhpadd3()))
                    setting.putInteger("ShieldHPAdd", setting.getInteger("ShieldHPAdd") + 15);
                else if (name.equals(InAppBillingResources.getShieldhpadd4()))
                    setting.putInteger("ShieldHPAdd", setting.getInteger("ShieldHPAdd") + 20);
                else if (name.equals(InAppBillingResources.getShieldhpadd5()))
                    setting.putInteger("ShieldHPAdd", setting.getInteger("ShieldHPAdd") + 45);

                else if (name.equals(InAppBillingResources.getENERGYADD()))
                    setting.putInteger("EnergyAdd", setting.getInteger("EnergyAdd") + 5);
                else if (name.equals(InAppBillingResources.getEnergyadd2()))
                    setting.putInteger("EnergyAdd", setting.getInteger("EnergyAdd") + 10);
                else if (name.equals(InAppBillingResources.getEnergyadd3()))
                    setting.putInteger("EnergyAdd", setting.getInteger("EnergyAdd") + 15);
                else if (name.equals(InAppBillingResources.getEnergyadd4()))
                    setting.putInteger("EnergyAdd", setting.getInteger("EnergyAdd") + 20);
                else if (name.equals(InAppBillingResources.getEnergyadd5()))
                    setting.putInteger("EnergyAdd", setting.getInteger("EnergyAdd") + 45);

                else if (name.equals(InAppBillingResources.getMICROWAVE()))
                    setting.putInteger("Microwave", setting.getInteger("Microwave") + 5);
                else if (name.equals(InAppBillingResources.getMicrowave2()))
                    setting.putInteger("Microwave", setting.getInteger("Microwave") + 10);
                else if (name.equals(InAppBillingResources.getMicrowave3()))
                    setting.putInteger("Microwave", setting.getInteger("Microwave") + 15);
                else if (name.equals(InAppBillingResources.getMicrowave4()))
                    setting.putInteger("Microwave", setting.getInteger("Microwave") + 20);
                else if (name.equals(InAppBillingResources.getMicrowave5()))
                    setting.putInteger("Microwave", setting.getInteger("Microwave") + 45);
            }
            setting.flush();
        }
    }

    @Override
    public void onSkuDetailsResponse(int responseCode, List<SkuDetails> skuDetailsList) {
        if (responseCode == BillingClient.BillingResponse.OK) {
            setting.putBoolean("isBuy", true);
            for (SkuDetails product : skuDetailsList) {
                String name = product.getSku();
                int price = (int) product.getPriceAmountMicros() / 1000000;

                if (name.equals(InAppBillingResources.getMONEY()))
                    setting.putFloat("PriceMoney", price);
                else if (name.equals(InAppBillingResources.getMoney2()))
                    setting.putFloat("PriceMoney_2", price);
                else if (name.equals(InAppBillingResources.getMoney3()))
                    setting.putFloat("PriceMoney_3", price);
                else if (name.equals(InAppBillingResources.getMoney4()))
                    setting.putFloat("PriceMoney_4", price);
                else if (name.equals(InAppBillingResources.getMoney5()))
                    setting.putFloat("PriceMoney_5", price);

                else if (name.equals(InAppBillingResources.getMINERAL()))
                    setting.putFloat("PriceMineral", price);
                else if (name.equals(InAppBillingResources.getMineral2()))
                    setting.putFloat("PriceMineral_2", price);
                else if (name.equals(InAppBillingResources.getMineral3()))
                    setting.putFloat("PriceMineral_3", price);
                else if (name.equals(InAppBillingResources.getMineral4()))
                    setting.putFloat("PriceMineral_4", price);
                else if (name.equals(InAppBillingResources.getMineral5()))
                    setting.putFloat("PriceMineral_5", price);

                else if (name.equals(InAppBillingResources.getSHIELDHPADD()))
                    setting.putFloat("PriceShieldHPAdd", price);
                else if (name.equals(InAppBillingResources.getShieldhpadd2()))
                    setting.putFloat("PriceShieldHPAdd_2", price);
                else if (name.equals(InAppBillingResources.getShieldhpadd3()))
                    setting.putFloat("PriceShieldHPAdd_3", price);
                else if (name.equals(InAppBillingResources.getShieldhpadd4()))
                    setting.putFloat("PriceShieldHPAdd_4", price);
                else if (name.equals(InAppBillingResources.getShieldhpadd5()))
                    setting.putFloat("PriceShieldHPAdd_5", price);

                else if (name.equals(InAppBillingResources.getENERGYADD()))
                    setting.putFloat("PriceEnergyAdd", price);
                else if (name.equals(InAppBillingResources.getEnergyadd2()))
                    setting.putFloat("PriceEnergyAdd_2", price);
                else if (name.equals(InAppBillingResources.getEnergyadd3()))
                    setting.putFloat("PriceEnergyAdd_3", price);
                else if (name.equals(InAppBillingResources.getEnergyadd4()))
                    setting.putFloat("PriceEnergyAdd_4", price);
                else if (name.equals(InAppBillingResources.getEnergyadd5()))
                    setting.putFloat("PriceEnergyAdd_5", price);

                else if (name.equals(InAppBillingResources.getMICROWAVE()))
                    setting.putFloat("PriceMicrowave", price);
                else if (name.equals(InAppBillingResources.getMicrowave2()))
                    setting.putFloat("PriceMicrowave_2", price);
                else if (name.equals(InAppBillingResources.getMicrowave3()))
                    setting.putFloat("PriceMicrowave_3", price);
                else if (name.equals(InAppBillingResources.getMicrowave4()))
                    setting.putFloat("PriceMicrowave_4", price);
                else if (name.equals(InAppBillingResources.getMicrowave5()))
                    setting.putFloat("PriceMicrowave_5", price);
            }
            setting.flush();
        } else {
            setting.putBoolean("isBuy", false);
            setting.flush();
        }
    }

    @Override
    public void onPurchaseHistoryResponse(int responseCode, List<Purchase> purchasesList) {
    }

    @Override
    public void onConsumeResponse(int responseCode, String purchaseToken) {
        billingClient.consumeAsync(purchaseToken, this);
    }

    @Override
    public boolean getSignedInGPGS() {
        // статус подключения
        System.out.println("*** Статус подключения GPGS " + googleApiClient.isConnected());
        return googleApiClient.isConnected();
    }

    @Override
    public void submitScoreGPGS(String id, int score) {
        // отправить игровые очки в достижения с ID
        if (getSignedInGPGS()) {
            if (id.equals("eventEarnMoney"))
                Games.Events.increment(googleApiClient, getString(R.string.eventEarnMoney), score);
            else if (id.equals("eventSpentMoney"))
                Games.Events.increment(googleApiClient, getString(R.string.eventSpentMoney), score);
            else if (id.equals("eventEarnMinerals"))
                Games.Events.increment(googleApiClient, getString(R.string.eventEarnMinerals), score);
            else if (id.equals("eventSpentMinerals"))
                Games.Events.increment(googleApiClient, getString(R.string.eventSpentMinerals), score);
            else if (id.equals("eventKillingMonsters"))
                Games.Events.increment(googleApiClient, getString(R.string.eventKillingMonsters), score);
            else if (id.equals("eventKillingBoss1"))
                Games.Events.increment(googleApiClient, getString(R.string.eventKillingBoss1), score);
            else if (id.equals("eventKillingBoss2"))
                Games.Events.increment(googleApiClient, getString(R.string.eventKillingBoss2), score);
            else if (id.equals("eventKillingBoss3"))
                Games.Events.increment(googleApiClient, getString(R.string.eventKillingBoss3), score);
            else if (id.equals("eventKillingBoss4"))
                Games.Events.increment(googleApiClient, getString(R.string.eventKillingBoss4), score);
            else if (id.equals("eventDeath"))
                Games.Events.increment(googleApiClient, getString(R.string.eventDeath), score);
        }
    }

    @Override
    public void loginGPGS() {
        if (!BaseGameUtils.verifySampleSetup(this, R.string.app_id))
            System.out.println("*** Внимание: обнаружены проблемы с установкой. Вход не работает!");
        System.out.println("*** Входим");
        signInClicked = true;
        googleApiClient.connect();
    }

    @Override
    public void logoutGPGS() {
        signInClicked = false;
        Games.signOut(googleApiClient);
        googleApiClient.disconnect();
    }

    @Override
    public void recordGPGS(String name, int score) {
        if (getSignedInGPGS()) {
            if (name.equals("Top")) Games.Leaderboards.submitScore(googleApiClient, getString(R.string.leaderboardTopDefenseGenerals), score);
            else if (name.equals("Money")) Games.Leaderboards.submitScore(googleApiClient, getString(R.string.leaderboardMonetarySavings), score);
            else if (name.equals("Mineral")) Games.Leaderboards.submitScore(googleApiClient, getString(R.string.leaderboardCrystalTycoon), score);
        }
    }

    @Override
    public void unlockAchievementGPGS(String achievementId) {
        // открыть достижение с ID achievementId

        if (getSignedInGPGS())
            Games.Achievements.unlock(googleApiClient, achievementId);
    }

    @Override
    public void getAchievementsGPGS() {
        // вызвать Activity с достижениями

        System.out.println("*** Список достижений");
        if (getSignedInGPGS())
            startActivityForResult(Games.Achievements.getAchievementsIntent(googleApiClient), 8700);
    }

    @Override
    public void getLeaderboardGPGS() {
        // вызвать Activity для всех зарегистрированных таблиц рекордов. Так же
        // можно вызывать Activity под конкретную таблицу

        if (getSignedInGPGS())
            startActivityForResult(Games.Leaderboards.getAllLeaderboardsIntent(googleApiClient), 8700);
    }

    @Override
    public void loadGameState() {
    }

    @Override
    public void saveGameState() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_RESOLVE_ERROR) {
            resolvingConnectionFailure = false;
            if (resultCode == RESULT_OK) {
                // Make sure the app is not already connected or attempting to connect
                if (!getSignedInGPGS()) {
                    googleApiClient.connect();
                }
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        System.out.println("*** onConnected() called. Sign in successful!");
    }

    @Override
    public void onConnectionSuspended(int i) {
        // Attempt to reconnect
        googleApiClient.connect();
        System.out.println("*** onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        System.out.println("*** onConnectionFailed() called, result: " + connectionResult);

        if (resolvingConnectionFailure) {
            // already resolving
            System.out.println("*** onConnectionFailed() ignoring connection failure; already resolving.");
            return;
        } else if (connectionResult.hasResolution()) {
            try {
                resolvingConnectionFailure = true;
                connectionResult.startResolutionForResult(this, REQUEST_RESOLVE_ERROR);
            } catch (IntentSender.SendIntentException e) {
                // There was an error with the resolution intent. Try again.
                googleApiClient.connect();
            }
        } else {
            // Show dialog using GoogleApiAvailability.getErrorDialog()
            showErrorDialog(connectionResult.getErrorCode());
            resolvingConnectionFailure = true;
        }

        // if the sign-in button was clicked or if auto sign-in is enabled,
        // launch the sign-in flow
        if (signInClicked || autoStartSignInflow) {
            autoStartSignInflow = false;
            signInClicked = false;
            resolvingConnectionFailure = true;

            // Attempt to resolve the connection failure using BaseGameUtils.
            // The R.string.signin_other_error value should reference a generic
            // error string in your strings.xml file, such as "There was
            // an issue with sign-in, please try again later."
            if (!BaseGameUtils.resolveConnectionFailure(
                            this,
                            googleApiClient,
                            connectionResult,
                            RC_SIGN_IN,
                            getString(R.string.sign_in_failed)
                    )
                    ) {
                resolvingConnectionFailure = false;
            }
        }
        // Put code here to display the sign-in button
    }

    // The rest of this code is all about building the error dialog

//    private FragmentActivity fragmentActivity = new FragmentActivity();

    /* Creates a dialog for an error message */
    private void showErrorDialog(int errorCode) {
        // Create a fragment for the error dialog
        FragmentActivity fragmentActivity = new FragmentActivity();
        ErrorDialogFragment dialogFragment = new ErrorDialogFragment();
        // Pass the error that should be displayed
        Bundle args = new Bundle();
        args.putInt(DIALOG_ERROR, errorCode);
        dialogFragment.setArguments(args);
        dialogFragment.show(fragmentActivity.getSupportFragmentManager(), "errordialog");
        resolvingConnectionFailure = dialogFragment.isResolvingConnectionFailure();
    }

    /* A fragment to display an error dialog */
    public static class ErrorDialogFragment extends DialogFragment {

        private boolean resolvingConnectionFailure = false;

        public ErrorDialogFragment() {
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Get the error code and retrieve the appropriate dialog
            int errorCode = this.getArguments().getInt(DIALOG_ERROR);
            return GoogleApiAvailability.getInstance().getErrorDialog(this.getActivity(), errorCode, REQUEST_RESOLVE_ERROR);
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
            resolvingConnectionFailure = false;
            System.out.println("*** onDismiss" + dialog);
        }

        public boolean isResolvingConnectionFailure() {
            return resolvingConnectionFailure;
        }
    }
}