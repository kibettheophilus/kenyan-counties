package com.theophiluskibet.kenyancounties.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.theophiluskibet.kenyancounties.models.Constituency;
import com.theophiluskibet.kenyancounties.models.County;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class CountyDataFetcher {
    public final List<County> counties = List.of(
            new County(1, "Mombasa",
                    List.of(
                            new Constituency("Changamwe", List.of("Port Reitz", "Kipevu", "Airport", "Miritini", "Chaani")),
                            new Constituency("Jomvu", List.of("Jomvu Kuu", "Magongo", "Mikindani"))
                    )
            ),
            new County(2, "Kwale",
                    List.of(
                            new Constituency("Kinango", List.of("Ndavaya", "Puma", "Kinango", "Chengoni/Samburu", "Mackinon Road", "Mwavumbo", "Kasemeni")),
                            new Constituency("Lunga Lunga", List.of("Pongwe/Kikoneni", "Dzombo", "Vanga", " Mwereni"))
                    )
            ),
            new County(3, "Kilifi",
                    List.of(
                            new Constituency("Kilifi North", List.of("Tezo", "Sokoni", "Kibarani", "Dabaso", "Matsangoni", "Watamu", "Mnarani")),
                            new Constituency("Kilifi South", List.of("Junju", "Mwarakaya", "Shimo la Tewa", "Chasimba", "Mtepeni"))
                    )
            )
    );

    @DgsQuery
    public List<County> getCounties(@InputArgument String name) {
        if (name == null) {
            return counties;
        }

        return counties.stream().filter(county -> county.getName().contains(name)).collect(Collectors.toList());
    }
}
