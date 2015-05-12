package me.jp.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * colorPrimaryDark
 * 状态栏背景色。
 *
 * textColorPrimary
 * App bar 上的标题与更多菜单中的文字颜色。
 * App bar 的背景色
 *
 * Actionbar 的背景色设定在 style 中的 colorPrimary。
 * Toolbar 的背景色在layout文件中设置background属性。
 * 
 * colorAccent
 * 各控制元件(如：check box、switch 或是 radoi) 被勾选 (checked) 或是选定 (selected) 的颜色。
 *
 * colorControlNormal
 * 各控制元件的预设颜色。
 *
 * windowBackground
 * App 的背景色。
 *
 * navigationBarColor
 * 导航栏的背景色，但只能用在 API Level 21 (Android 5) 以上的版本
 */
public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        initToolBar();

    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // App Logo
        toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("My Title");
        // Sub Title
        toolbar.setSubtitle("Sub title");

        setSupportActionBar(toolbar);

        // Navigation Icon 要设定在 setSupoortActionBar 才有作用，否则会出现back bottom
        toolbar.setNavigationIcon(R.mipmap.ab_android);
        // Menu item click 的监听事件一定要设置在 setSupportActionBar 才有作用
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    msg += "Click edit";
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";
                    break;
            }

            if (!msg.equals("")) {
                Toast.makeText(ToolbarActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 为了让 Toolbar 的 Menu 有作用，需要有这句
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

}
