package albert.miguel.permisd.fo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import albert.miguel.permisd.R;

public class FoInspecteur8Fragment extends Fragment {

    int fragVal;
    static Fragment init(int val) {
        FoInspecteur8Fragment FoInspecteur8Fragment = new FoInspecteur8Fragment();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        FoInspecteur8Fragment.setArguments(args);
        return FoInspecteur8Fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragVal = getArguments() != null ? getArguments().getInt("val") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fo_inspecteur_8_fragment, container,
                false);
        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) layoutView.findViewById(R.id.imageView);
        imageView.setImage(ImageSource.resource(R.drawable.fiche08));
        return layoutView;
    }
}
