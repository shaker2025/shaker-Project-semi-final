package edu.oakland.payroll;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class LanguageSelectionActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "AppPrefs";
    private static final String KEY_LANGUAGE = "Language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        Button englishButton = findViewById(R.id.buttonEnglish);


        englishButton.setOnClickListener(v -> setLanguageAndProceed("en"));

    }

    private void setLanguageAndProceed(String languageCode) {
        // Save selected language to shared preferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        prefs.edit().putString(KEY_LANGUAGE, languageCode).apply();

        // Update app language
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        getResources().getConfiguration().setLocale(locale);

        // Proceed to MainActivity
        Intent intent = new Intent(LanguageSelectionActivity.this, EmployeeList.class);
        startActivity(intent);
        finish();
    }
}
