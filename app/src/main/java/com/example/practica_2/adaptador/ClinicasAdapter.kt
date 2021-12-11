package com.example.practica_2.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_2.R
import com.example.practica_2.UI.FormularioActivity
import com.example.practica_2.config.Constantes
import com.example.practica_2.databinding.ItemListBinding
import com.example.practica_2.models.Clinicas


class ClinicasAdapter(private val dataSet: List<Clinicas>?) :
    RecyclerView.Adapter<ClinicasAdapter.ViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val item = dataSet?.get(position)
        viewHolder.enlazarItem(item!!)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet!!.size

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemListBinding.bind(view)
        var context = view.context
        fun enlazarItem(clinicas: Clinicas) {
            binding.tvTipoInstitute.text = "${clinicas.tipo} ${clinicas.idClinica}"
            binding.TvContacto.text = clinicas.contacto
            binding.tvLugar.text = clinicas.lugar

            binding.root.setOnClickListener {
                val intent = Intent(context,FormularioActivity::class.java)
                intent.putExtra(Constantes.OPERACION_KEY,Constantes.OPERACION_EDITAR)
                intent.putExtra(Constantes.ID_CLINICA_KEY, clinicas.idClinica)
                context.startActivity(intent)
            }
        }
    }

}
