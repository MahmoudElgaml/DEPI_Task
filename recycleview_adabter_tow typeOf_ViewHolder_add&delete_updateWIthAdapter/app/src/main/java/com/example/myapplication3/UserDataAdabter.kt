package com.example.myapplication3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.databinding.Card2Binding
import com.example.myapplication3.databinding.CardBinding
import com.example.myapplication3.databinding.FragmentBlank2Binding

class UserDataAdapter(val onItemDelete:(Pair<User,Int>)->Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

       private val userList:MutableList<User> = mutableListOf()
       fun setList(user:List<User>){
           userList.clear()
           userList.addAll(user)

       }
    inner class ViewHolderOne(val binding: CardBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData (user:User){
            binding.name.text=user.name
            binding.idd.text=user.phone
            binding.mail.text=user.mail
            binding.deleteButton.setOnClickListener{
                onItemDelete(Pair(user,adapterPosition))
            }
        }

    }
    inner class ViewHolderTow(val binding: Card2Binding):RecyclerView.ViewHolder(binding.root){
        fun bindData (user:User){
            binding.name.text=user.name
            binding.idd.text=user.phone
        }

    }

    override fun getItemViewType(position: Int): Int {
        return  when(userList[position].type){
            1-> holderTypeOne
            2-> holderTypeTow
            else -> holderTypeOne
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return  when(viewType){
           holderTypeOne->{
               val binding=CardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
               return  ViewHolderOne(binding)
           }
           holderTypeTow->{
               val binding=Card2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
               return  ViewHolderTow(binding)
           }
           else ->throw IllegalAccessException("opss")
       }

    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            holderTypeOne->(holder as ViewHolderOne).bindData(userList[position])
            holderTypeTow->(holder as ViewHolderTow).bindData(userList[position])
        }

    }
    companion object{
        private  const val holderTypeOne=1
        private  const val holderTypeTow=2

    }

}