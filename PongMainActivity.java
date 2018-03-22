package com.example.jacobsa20.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jacobsa20.animation.AnimationSurface;
//import com.example.jacobsa20.jacobsa20pong.R;

/**
 * PongMainActivity
 * 
 * This is the activity for the Pong game. It attaches a PongAnimator to
 * an AnimationSurface.
 * 
 * @author Andrew Nuxoll
 * @author Steven R. Vegdahl
 * @version July 2013
 * 
 */
public class PongMainActivity extends Activity implements View.OnClickListener {

	/**
	 * creates an AnimationSurface containing a TestAnimator.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pong_main);

		// Connect the animation surface with the animator
		AnimationSurface mySurface = (AnimationSurface) this
				.findViewById(R.id.animationSurface);
		mySurface.setAnimator(new PongGame());

		//finding references to add ball button
        Button addBallButton= (Button)findViewById(R.id.ballButton);

        //create listener for button
       // Ball ball= new Ball();
        addBallButton.setOnClickListener(this);
	}

    @Override
    public void onClick(View v) {
        //when button is clicked perform action
        if(v.getId()== R.id.ballButton){
         //   pong
        }
    }
}
