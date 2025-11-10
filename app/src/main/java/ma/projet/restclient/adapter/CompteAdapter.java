package ma.projet.restclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ma.projet.restclient.R;
import ma.projet.restclient.models.Compte;

public class CompteAdapter extends RecyclerView.Adapter<CompteAdapter.CompteViewHolder> {

    private List<Compte> comptes;
    private OnItemClickListener onEditClick;
    private OnItemClickListener onDeleteClick;

    public interface OnItemClickListener {
        void onClick(Compte compte);
    }

    public CompteAdapter(List<Compte> comptes, OnItemClickListener onEditClick, OnItemClickListener onDeleteClick) {
        this.comptes = comptes;
        this.onEditClick = onEditClick;
        this.onDeleteClick = onDeleteClick;
    }

    @NonNull
    @Override
    public CompteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_compte, parent, false);
        return new CompteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompteViewHolder holder, int position) {
        Compte compte = comptes.get(position);

        holder.tvId.setText("Account #" + String.format(Locale.getDefault(), "%04d", compte.getId() != null ? compte.getId() : 0));
        holder.tvSolde.setText(String.format(Locale.getDefault(), "%.2f DH", compte.getSolde()));
        holder.tvDate.setText("Created: " + formatDate(compte.getDateCreation()));
        holder.tvType.setText(compte.getType() != null ? compte.getType().name() : "N/A");

        holder.btnEdit.setOnClickListener(v -> {
            if (onEditClick != null) {
                onEditClick.onClick(compte);
            }
        });

        holder.btnDelete.setOnClickListener(v -> {
            if (onDeleteClick != null) {
                onDeleteClick.onClick(compte);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comptes.size();
    }

    public void updateData(List<Compte> newComptes) {
        comptes.clear();
        comptes.addAll(newComptes);
        notifyDataSetChanged();
    }

    public void removeItem(Compte compte) {
        int position = comptes.indexOf(compte);
        if (position != -1) {
            comptes.remove(position);
            notifyItemRemoved(position);
        }
    }

    private String formatDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return "Date non disponible";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            Date date = inputFormat.parse(dateStr);
            return outputFormat.format(date != null ? date : new Date());
        } catch (Exception e) {
            return dateStr;
        }
    }

    static class CompteViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvSolde;
        TextView tvDate;
        TextView tvType;
        ImageButton btnEdit;
        ImageButton btnDelete;

        CompteViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvCompteId);
            tvSolde = itemView.findViewById(R.id.tvCompteSolde);
            tvDate = itemView.findViewById(R.id.tvCompteDate);
            tvType = itemView.findViewById(R.id.tvCompteType);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

