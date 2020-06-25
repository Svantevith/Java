package android.example.com.miwokapplication;

public class Word
{
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    //m at the beginning of the variable means , that the variable is a member of the class
    //as well as:
    //Non-public (private or protected), non-static field names start with m.
    //Static field names start with s.
    // Other fields start with a lower case letter.
    // Public static final fields (constants) are ALL_CAPS_WITH_UNDERSCORES.

    public Word(String defaultTranslation, String miwokTranslation)
            //constructor of Word class objects
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }


}
