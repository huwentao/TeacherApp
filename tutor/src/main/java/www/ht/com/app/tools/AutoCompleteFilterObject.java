package www.ht.com.app.tools;

import android.database.Cursor;

/**
 * Created by monkey on 2015/8/17.
 */
public interface AutoCompleteFilterObject {

    public String getSearchWord();

    public AutoCompleteFilterObject createObject(Cursor cursor);
}
