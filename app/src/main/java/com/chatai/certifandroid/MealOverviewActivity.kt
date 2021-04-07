package com.chatai.certifandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chatai.certifandroid.Data.Models.Meal
import kotlinx.android.synthetic.main.activity_meal_overview.*

class MealOverviewActivity : AppCompatActivity() {

    lateinit var myMeal : Meal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_overview)

        val page = intent.getIntExtra("meal",1)

        meal_return.setOnClickListener{
            finish()
        }

        if (page == 1){
            meal_category.setText("Catégorie : Oeuf")
            meal_description.setText("STEP 1 Remove the large piece of fat on the edge of each pork loin, then bash each of the loins between two pieces of baking parchment until around 1cm in thickness – you can do this using a meat tenderiser or a rolling pin. Once bashed, use your hands to reshape the meat to its original shape and thickness – this step will ensure the meat is as succulent as possible. STEP 2 Put the flour, eggs and panko breadcrumbs into three separate wide-rimmed bowls. Season the meat, then dip first in the flour, followed by the eggs, then the breadcrumbs. STEP 3 In a large frying or sauté pan, add enough oil to come 2cm up the side of the pan. Heat the oil to 180C – if you don’t have a thermometer, drop a bit of panko into the oil and if it sinks a little then starts to fry, the oil is ready. Add two pork chops and cook for 1 min 30 secs on each side, then remove and leave to rest on a wire rack for 5 mins. Repeat with the remaining pork chops. STEP 4 While the pork is resting, make the sauce by whisking the ingredients together, adding a splash of water if it’s particularly thick. Slice the tonkatsu and serve drizzled with the sauce.")
            meal_id.setText("ID : 53032")
            meal_img.setImageResource(R.drawable.eggs)
            meal_name.setText("Tonkatsu pork")
            meal_quantity.setText("x 2")
            meal_time.setText("Commandé à 19h15 - 07/04/2021")
        }
        else if(page == 2){

            meal_category.setText("Catégorie : Poulet")
            meal_description.setText("Bring to a boil over medium heat. Remove lid and cook for one minute once boiling. Meanwhile, stir together the corn starch and 2 tablespoons of water in a separate dish until smooth. Once sauce is boiling, add mixture to the saucepan and stir to combine. Cook until the sauce starts to thicken then remove from heat. Place the chicken breasts in the prepared pan. Pour one cup of the sauce over top of chicken.")
            meal_id.setText("ID : 52772")
            meal_img.setImageResource(R.drawable.salade)
            meal_name.setText("Teriyaki Chicken Casserole")
            meal_quantity.setText("x 1")
            meal_time.setText("Commandé à 19h46 - 07/04/2021")

        }
        else if(page == 3){

            meal_category.setText("Catégorie : Porc")
            meal_description.setText("Sizzle for a couple of mins so the sauce thickens a little and the tonkatsu reheats. STEP 2 Tip the beaten eggs around the tonkatsu and cook for 2-3 mins until the egg is cooked through but still a little runny.")
            meal_id.setText("ID : 53034")
            meal_img.setImageResource(R.drawable.meat)
            meal_name.setText("Japanese Katsudon")
            meal_quantity.setText("x 10")
            meal_time.setText("Commandé à 23h26 - 07/04/2021")
        }
    }
}