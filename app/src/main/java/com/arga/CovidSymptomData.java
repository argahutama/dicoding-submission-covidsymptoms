package com.arga;

import java.util.ArrayList;

class CovidSymptomData {

    private static String[] symptom = {
            "Cough With or Without Phlegm", "Fever", "Lost Smell and Taste", "Fatigue", "Diarrhea", "Conjunctivitis", "Shivering", "Short Breaths", "Emergency Warning Signs", "Headache"
    };

    private static String[] symptomDetails = {
            "Coughing is a common symptom of corona virus infection. However, the cough that appears is not an ordinary cough. Even though dry cough is a sign, a WHO report in February 2020 states that 33 percent of 55,924 people with Covid-19 experience coughing up phlegm or thick phlegm, sometimes called phlegm.",
            "One of the most common symptoms of fever is that your body temperature rises in the afternoon and late afternoon. That is the common way viruses produce fever.",
            "Loss of ability to smell and taste can be an unusual symptom in people with Covid-19 with mild to moderate cases.",
            "People who experience extreme fatigue can be an early sign of the corona virus. WHO reports, nearly 40 percent of the 6,000 positive people of Covid-19 claim to be experiencing fatigue. This feeling of fatigue can even continue long after the virus has disappeared.",
            "Initially, the researchers did not consider diarrhea or gastric problems as a sign of Covid-19. However, that opinion has changed. Patients who experience digestive problems are mostly late in undergoing the Covid-19 test compared to patients who experience symptoms of shortness of breath.",
            "Conjunctivitis or red eyes occurs due to inflammation due to a virus in a thin and transparent layer of tissue that covers the white part of the eye and the inside of the eyelid called the conjunctiva. The pink eye condition should be suspected as a sign of Covid-19 when followed by several other signs such as fever, coughing, or shortness of breath.",
            "Some patients with Covid-19, said he was shivering, his body ached, and a high fever at night.",
            "Shortness of breath generally appears as a sign of illness reaching a serious stage. In fact, it can appear without being accompanied by a cough. Experts say, when your chest feels like it\\'s bound or is starting to feel difficulty breathing, this is a sign you need to act fast.",
            "In some patients, when conditions worsen, they experience a number of emergencies. The CDC warns, if the body is unable to get up or move from a lying position, or lose response, this can be a serious sign that you need immediate treatment. If someone shows the symptoms above accompanied by blue lips, difficulty breathing, and chest pain, then you should immediately seek help.",
            "The WHO report also found that nearly 14 percent of the nearly 6,000 Covid-19 patients in China experienced symptoms of headaches and sore throats. Meanwhile, almost 5 percent experience nasal congestion. Although not a common sign and more similar to the flu, but the symptoms of Covid-19 can basically look like the flu including headaches and digestive problems."
    };

    private static int[] symptomPictures = {
            R.drawable.batuk,
            R.drawable.demam,
            R.drawable.kehilangan_bau_rasa,
            R.drawable.kelelahan,
            R.drawable.masalah_pencernaan,
            R.drawable.mata_merah,
            R.drawable.menggigil,
            R.drawable.nafas_pendek,
            R.drawable.nyeri_dada,
            R.drawable.sakit_kepala
    };

    static ArrayList<Symptoms> getListData() {
        ArrayList<Symptoms> list = new ArrayList<>();
        for (int position = 0; position <symptom.length; position++) {
            Symptoms symptoms = new Symptoms();
            symptoms.setSymptoms(symptom[position]);
            symptoms.setSymptomDetails(symptomDetails[position]);
            symptoms.setSymptomPictures(symptomPictures[position]);
            list.add(symptoms);
        }
        return list;
    }
}