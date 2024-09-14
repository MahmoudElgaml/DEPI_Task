package com.example.myapplication3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.example.myapplication3.databinding.FragmentBlank1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding :FragmentBlank1Binding
    lateinit var  name: String
    lateinit var  mail: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank1Binding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

      binding.nammme.doAfterTextChanged {
          name=binding.nammme.text.toString()


      }
      binding.maail.doAfterTextChanged {
          mail=binding.maail.text.toString()


      }
        binding.button.setOnClickListener{
           findNavController().navigate(R.id.blankFragment2
               , bundleOf(
                  "name" to name,
                   "mail" to mail,
               ))

        }

    }


}