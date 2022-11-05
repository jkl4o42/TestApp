package jkl4o4.testapp.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import jkl4o4.testapp.R
import jkl4o4.testapp.numbers.presentation.NumbersFragment

class MainActivity : AppCompatActivity(), ShowFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) show(NumbersFragment(), false)
    }

    override fun show(fragment: Fragment) {
        show(fragment, true)
    }

    private fun show(fragment: Fragment, add: Boolean) {
        /// TODO: make OOP
        val transaction = supportFragmentManager.beginTransaction()
        val container = R.id.container
        if (add) {
            transaction.add(container, fragment)
                .addToBackStack(fragment.javaClass.simpleName)
        } else {
            transaction.replace(container, fragment)
        }
        transaction.commit()
    }


}

interface ShowFragment {

    fun show(fragment: Fragment)

    class Empty : ShowFragment {

        override fun show(fragment: Fragment) = Unit
    }
}