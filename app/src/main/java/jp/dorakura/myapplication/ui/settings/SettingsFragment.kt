package jp.dorakura.myapplication.ui.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jp.dorakura.myapplication.R
import jp.dorakura.myapplication.databinding.FragmentHomeBinding
import jp.dorakura.myapplication.ui.home.HomeViewModel

class SettingsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_settings, container, false)
        return root
        }
    }