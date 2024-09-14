package com.example.myapplication3

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication3.databinding.FragmentBlank2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters


    lateinit var binding: FragmentBlank2Binding
     val list = mutableListOf<User>()
    lateinit var userAdapter:UserDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank2Binding.inflate(layoutInflater, container, false)

        return binding.root
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        list.add(
            User("mahmoud", "1","mahmoud@gmail.com",1)

        )
        list.add(
            User("mahmoud3", "2","mahmoud@gmail.com",1)

        )
        list.add(
            User("mahmoud4", "3","mahmoud@gmail.com",1)

        )
        list.add(
            User("mahmoud5", "4","mahmoud@gmail.com",1)

        )
        list.add(
            User("mahmoud6", "5","mahmoud@gmail.com",1)

        )

        binding.floatButton.setOnClickListener{
            addInfo()
        }

        binding.mylist.layoutManager=LinearLayoutManager(requireContext())
        userAdapter =UserDataAdapter(){
            list.remove(it.first)
            userAdapter.setList(list)
            userAdapter.notifyDataSetChanged()
        }
        binding.mylist.adapter=userAdapter
        userAdapter.setList(list)
        userAdapter.notifyDataSetChanged()



    }


    private fun addInfo() {
        val v =LayoutInflater.from(requireContext()).inflate(R.layout.dialogg,null)
        val name=v.findViewById<EditText>(R.id.dialogName)
        val mail=v.findViewById<EditText>(R.id.dialogMail)
        val phone=v.findViewById<EditText>(R.id.dialogPhone)
        val addDialog=AlertDialog.Builder(requireContext())
        addDialog.setView(v)
        addDialog.setPositiveButton("ok"){
            dialog,_->
            val names=  name.text.toString()
            val mails=mail.text.toString()
            val phons=phone.text.toString()
            list.add(User(names,phons,mails,1))
            userAdapter.setList(list)
            userAdapter.notifyDataSetChanged()

            dialog.dismiss()


        }
        addDialog.setNegativeButton("cansel"){
            dialog,_->
            dialog.dismiss()
        }
        addDialog.create()
        addDialog.show()


    }

}